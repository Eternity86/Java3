package Java3.lessons.lesson1.task1;

public class SwapElems {
	public static void main(String[] args) {

	}

	public static void swap(Object[] arr, int indexOne, int indexTwo) {
		if (indexOne > 0 && indexOne <= arr.length && indexTwo > 0 && indexTwo <= arr.length) {
			Object temp = arr[indexOne - 1];
			arr[indexOne - 1] = arr[indexTwo - 1];
			arr[indexTwo - 1] = temp;
		} else {
			System.out.println("Выход за пределы массива. Индекс элемента массива должен быть от 1 до " + arr.length);
		}

	}
}
