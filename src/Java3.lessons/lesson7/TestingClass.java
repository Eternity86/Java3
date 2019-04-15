package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingClass {
    private static final int LOW_PRIORITY = 1;
    private static final int HIGH_PRIORITY = 10;

    public static void start(Class c) {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        // проходимся по всем методам тестируемого класса
        // и добавляем в список методы с аннотацией Test
        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {
                int priority = o.getAnnotation(Test.class).priority();
                if (priority < LOW_PRIORITY || priority > HIGH_PRIORITY) {
                    throw new RuntimeException("Priority exception");
                }
                list.add(o);
            }
        }
        // сортируем методы по приоритету в убывающем порядке,
        // используя переопределённый метод sort у списка list
        list.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());
        for (Method o : methods) {
            // метод с аннотацией BeforeSuite ставим в список первым
            // если встречаем ещё один метод с такой аннотацией - кидаем exception
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (list.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("BeforeSuite exception");
                }
                list.add(0, o);
            }
            // аналогично для метода с AfterSuite
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (list.get(list.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("AfterSuite exception");
                }
                list.add(o);
            }
        }
        // вызываем каждый метод тестируемого класса с нужными нам аннотациями
        for (Method o : list) {
            try {
                o.invoke(c.newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
