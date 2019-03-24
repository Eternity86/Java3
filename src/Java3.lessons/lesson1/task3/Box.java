package Java3.lessons.lesson1.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
	private static final float RESIDUAL = 0.00001f;
	private ArrayList<T> boxContent;

	@SafeVarargs
	public Box(T... arr) {
		boxContent = new ArrayList<>(Arrays.asList(arr));
	}

	public float getWeight() {
		if (boxContent.isEmpty()) return  0.0f;
		return boxContent.get(0).getWeight() * boxContent.size();
	}

	public void addFruit(T fruit) {
		boxContent.add(fruit);
	}

	public boolean compare(Box anotherBox) {
		return Math.abs(this.getWeight() - anotherBox.getWeight()) < RESIDUAL;
	}

	//при пересыпании фруктов из коробки в коробку ограничим другую коробку только фруктами того же типа, чтобы избежать "смешивания" фруктов
	public void shiftFruits(Box<? super T> anotherBox) {
		anotherBox.boxContent.addAll(this.boxContent);
		this.boxContent.clear();
	}

}