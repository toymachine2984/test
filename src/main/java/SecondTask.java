import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondTask {

    private static int value;

    public static void main(String[] args) throws IOException {

        SecondTask task = new SecondTask();
        int i = task.readLine();
        System.out.println("your number : " + i);
        int sum = 0;
        System.out.println(task.generate(i, sum));
    }

    public int readLine() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter number ");
            String input = reader.readLine();
            value = Integer.valueOf(input);
        } catch (NumberFormatException ex) {
            System.out.println("Not a number \r\ntry again");
            readLine();
        } finally {
            reader.close();
        }
        return value;
    }

    public int run(int i) {

        System.out.println("your number : " + i);
        int sum = 0;
        sum = generate(i, sum);
        System.out.println(sum);
        return sum;
    }


    public int generate(int i, int sum) {
        if (i == 0) {
            return sum;
        }
        int v = i % 10;
        sum = sum + v;
        int v2 = (i - v) / 10;
        sum = generate(v2, sum);
        return sum;
    }
}
