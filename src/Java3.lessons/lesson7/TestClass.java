package lesson7;

public class TestClass {

  @BeforeSuite
  void method1() {
	System.out.println("method 1 - BeforeSuite");
  }

  @Test(priority = 2)
  void method2() {
	System.out.println("method 2 - Test");
  }

  @Test(priority = 6)
  void method3() {
	System.out.println("method 3 - Test");
  }

  @Test
  void methodA() {
	System.out.println("methodA - Test");
  }

  @AfterSuite
  void method4() {
	System.out.println("method 4 - AfterSuite");
  }
}
