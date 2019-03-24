package Java3.lessons.lesson1.task3;

class Apple extends Fruit {

	public Apple() {
		super(1.0f);
	}

	@Override
	public Fruit newInstance() {
		return new Apple();
	}

}
