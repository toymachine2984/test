import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test3 {

    private static ThridTask task;

    @BeforeClass
    public static void before() {
        task = new ThridTask();
    }

    @Test
    public void sdin() {
        task.main(null);
    }

    @Test
    public void test() {
        task = new ThridTask(10);
        task.fill();
        task.generate("X");
        task.generate("O");
        task.sout();
        System.out.println(task.isCanWin(("X")));
    }


    @Test
    public void test2() {
        task = new ThridTask(20);
        task.fill();
        task.generate("X");
        task.generate("O");
        task.sout();
        System.out.println(task.isCanWin(("X")));
    }

    @Test
    public void test3() {
        task = new ThridTask(40);
        task.fill();
        task.generate("X");
        task.generate("O");
        task.sout();
        System.out.println(task.isCanWin(("X")));
        System.out.println(task.isCanWin(("O")));
    }

    @Test
    public void test4(){
        String[][] m = {{"X","X",".","X","X",".",".",".",".","."},
                {".",".",".",".",".","O","O","O","O","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".",".",".",".","."}};
        ThridTask task = new ThridTask(m);
        String canWin = task.isCanWin("X");
        System.out.println(canWin);
        Assert.assertEquals("YES",canWin);
    }

    @Test
    public void test5(){
String[][] m = {{"X",".","O",".",".",".",".",".",".","."},
                {".","X",".",".",".",".","O","O","O","."},
                {".",".",".",".",".",".",".","O",".","."},
                {".",".",".","X",".",".",".","O",".","."},
                {".",".",".",".","X",".",".","X",".","."},
                {".",".",".",".",".",".",".",".",".","."},
                {".",".",".",".",".",".","O",".",".","."},
                {".",".",".",".",".","O",".",".",".","."},
                {".",".",".",".","X",".",".",".",".","."},
                {".",".",".","O",".",".",".",".",".","."}};
        ThridTask task = new ThridTask(m);
        String x = task.isCanWin("X");
        String o = task.isCanWin("O");
        System.out.println(x);
        System.out.println(o);
        Assert.assertEquals("YES",x);
        Assert.assertEquals("NO",o);
    }

}
