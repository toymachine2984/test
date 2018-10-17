import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

public class Test1 {

    private static FirstTask task;

    @BeforeClass
    public static void before() {
        task = new FirstTask();
    }


    @Test
    public void sumNumber() {
        String var = "65466668599930231423";
        Assert.assertEquals(var, task.sumNumber("65423414235364756856", "43254364565474567"));
    }


    @Test
    public void sumNumber2() {
        String var = "1211022511";
        Assert.assertEquals(var, task.sumNumber("877601318", "333421193"));
    }

    @Test
    public void sumNumber3() {
        String var = "1795892476";
        Assert.assertEquals(var, task.sumNumber("661364300", "1134528176"));
    }

    @Test
    public void isDigit() {
        Random random = new Random();
        int iter = random.nextInt(100);
        for (int i = 0; i <= iter; i++) {
            Assert.assertTrue(task.isDigit(String.valueOf(random.nextInt(Integer.MAX_VALUE))));
        }
        for (int i = 0; i < iter; i++) {
            Assert.assertFalse(task.isDigit(UUID.randomUUID().toString()));
        }
    }

    @Test
    public void sum2() {
        Random random = new Random();
        int iter = random.nextInt(100);
        for (int i = 0; i <= iter; i++) {
//            int i1 = random.nextInt(Integer.MAX_VALUE); // FIXME: 17.10.2018 digit out of range
//            int i2 = random.nextInt(Integer.MAX_VALUE);
            int i1 = random.nextInt(99999);
            int i2 = random.nextInt(999999999);
            System.out.println(i1);
            System.out.println(i2);
            System.out.println(Long.valueOf(i1 + i2));
            System.out.println("===========================");
            Assert.assertEquals(
                    String.valueOf(Long.valueOf(i1 + i2)),
                    task.sumNumber(String.valueOf(i1), String.valueOf(i2))
            );
        }


    }
}
