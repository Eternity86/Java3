package Java3.lessons.lesson1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArray {
	public static void main(String[] args) {
		String[] arrayOfStrings = {"1", "2", "3", "4"};
		List<String> listOfStrings = convert(arrayOfStrings);
		for (String str : listOfStrings)
			System.out.print(" " + str);
		listOfStrings.add("5");
		System.out.println();
		for (String str : listOfStrings)
			System.out.print(" " + str);

	}

	private static <T> ArrayList<T> convert(T[] arr) {
		return new ArrayList<>(Arrays.asList(arr));
	}

}