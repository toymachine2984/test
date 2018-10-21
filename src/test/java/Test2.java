import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class Test2 {

    private static SecondTask task;

    @BeforeClass
    public static void before() {
        task = new SecondTask();
    }

    @Test
    public void run() {
        Random random = new Random();
        for (int j = 0; j < random.nextInt(20); j++) {
            task.run(random.nextInt(Integer.MAX_VALUE));
        }
    }


    @Test
    public void test() {
        Assert.assertEquals(40,task.run(1513274845));
    }

    @Test
    public void test2() {
        Assert.assertEquals(45,task.run(1936565190));
    }

    @Test
    public void test3() {
        Assert.assertEquals(42,task.run(725123697));
    }

    @Test
    public void test4() {
        Assert.assertEquals(58,task.run(1264894699));
    }
}
