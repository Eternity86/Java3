package lesson6.task3;

public class CheckOneAndFour {
  public boolean doCheckOneAndFour(int[] arr) {
    boolean result = true;
    int countOnes = 0;
    int countFours = 0;
    int i = 0;
    while (result && i < arr.length) {
      if (arr[i] == 1) {
        countOnes++;
	  } else if (arr[i] == 4) {
        countFours++;
	  } else {
        result = false;
	  }
      i++;
	}
    return result && countOnes > 0 && countFours > 0;
  }
}
