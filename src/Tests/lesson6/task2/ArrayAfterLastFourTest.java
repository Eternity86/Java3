package lesson6.task2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ArrayAfterLastFourTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {new int[] {1, 3}, new int[] {8, 3, 5, 4, 1, 3}},
        {new int[] {5, 3}, new int[] {2, 1, 4, 5, 3}},
        {new int[] {3}, new int[] {2, 1, 4, 5, 3, 4, 3}},
        {new int[] {1}, new int[] {1, 1, 1, 4, 1}},
        {new int[] {}, new int[] {1, 1, 1, 4}},
        //{new RuntimeException(), new int[] {1, 1, 1, 1}},
        {new int[] {0}, new int[] {4, 4, 1, 4, 0}}
    });
  }
  private ArrayAfterLastFour arrayAfterLastFour;
  private int[] a;
  private int[] b;

  public ArrayAfterLastFourTest(int[] a, int[] b) {
    this.a = a;
    this.b = b;
  }


  @Before
  public void startTest() throws Exception {
    arrayAfterLastFour = new ArrayAfterLastFour();
    System.out.println("Инициализация");
  }

  @After
  public void endTest() throws Exception {
    System.out.println("Финализация");
  }

  @Test
  public void doArrayAfterLastFourTest1() {
    assertArrayEquals(a, arrayAfterLastFour.doArrayAfterLastFour(b));
    System.out.println(Arrays.toString(arrayAfterLastFour.doArrayAfterLastFour(b)));
  }

}
