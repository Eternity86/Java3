package Java3.lessons.lesson1.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
	private ArrayList<T> list;

	public Box(T... arr) {
		list = new ArrayList<>(Arrays.asList(arr));
	}

	public float getWeight() {
		if (list.isEmpty()) return  0.0f;
		return list.get(0).getWeight() * list.size();
	}

	public void addFruit(T fruit) {
		list.add(fruit);
	}

	public boolean compare(Box another) {
		return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
	}

	public void shiftFruits(Box<? super T> another) {
		another.list.addAll(this.list);
		this.list.clear();
	}

}