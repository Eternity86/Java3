package lesson5.task1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int carsCount;

    static {
        carsCount = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier stopLine;
    // какой поток первым увеличит данную переменную после всех этапов гонки, тот и победитель =)
    private static AtomicInteger winCounter = new AtomicInteger(0);

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        carsCount++;
        this.name = "Участник №" + carsCount;
        stopLine = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            stopLine.await();
            // пока выводятся сообщения о подготовке и готовности к гонке,
            // все участники-потоки попадают к линии старта
            stopLine.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            if (winCounter.incrementAndGet() == 1) {
                System.out.println(name.toUpperCase() + " - ПОБЕДИТЕЛЬ!");
            }
            stopLine.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
