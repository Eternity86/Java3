package Java3.lessons.lesson1.task3;

abstract class Fruit {
	protected float weight;

	public Fruit(float weight) {
		this.weight = weight;
	}

	public abstract Fruit newInstance();

	public float getWeight() {
		return weight;
	}

}