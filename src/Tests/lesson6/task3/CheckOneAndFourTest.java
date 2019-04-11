package lesson6.task3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckOneAndFourTest {
  @Parameterized.Parameters
  public static Collection<Object> data() {
    return Arrays.asList(new Object[] {
        new int[] {1, 4, 4, 1, 4},
        new int[] {2, 1, 4, 5, 3},
        new int[] {2, 1, 4, 5, 3, 4, 4},
        new int[] {1, 1, 1, 1, 1},
        new int[] {4, 4, 1, 4, 4},
    });
  }
  private CheckOneAndFour checkOneAndFour;
  private int[] a;
  public CheckOneAndFourTest(int[] a) {
    this.a = a;
  }

  @Before
  public void startTest() {
    checkOneAndFour = new CheckOneAndFour();
    System.out.println("Инициализация");
  }

  @After
  public void endTest() {
    System.out.println("Финализация");
  }

  @Test
  public void doCheckOneAndFour() {
    Assert.assertEquals(true, checkOneAndFour.doCheckOneAndFour(a));
  }


}
