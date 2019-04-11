package lesson6.task2;

public class ArrayAfterLastFour {
  public int[] doArrayAfterLastFour(int[] arr) throws RuntimeException {
    int[] result;
    int i = arr.length - 1; // индекс последнего элемента массива - начинаем просмотр массива с конца
    int j = 0;
    boolean isFound = false; // флаг обнаружения последней четвёрки в массиве
    while (i >= 0 && !isFound) {
      isFound = (arr[i] == 4);
      j = i;
      i--;
	}
    if (isFound) {
	  // создаём новый массив длиной от последней четвёрки до конца исходного массива
      result = new int[arr.length - j - 1];
	  // и потом копируем из исходного массива в новый
      for (i = j + 1; i < arr.length; i++) {
        result[i - j - 1] = arr[i];
	  }
	} else {
      throw new RuntimeException("В массиве отсутствуют четвёрки!");
	}
    return result;
  }
}
