package Java3.lessons.lesson1.task3;

public class Orange extends Fruit {

	public Orange() {
		super(1.5f);
	}

	@Override
	public Fruit newInstance() {
		return new Orange();
	}
}
