import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondTask {

    public static void main(String[] args) throws  IOException {

        SecondTask task = new SecondTask();
        int i = task.readLine();
        System.out.println("your number : " + i);
        int sum = 0;
        System.out.println(task.generate(i, sum));
    }

    public int readLine() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number ");
        String input = reader.readLine();
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException ex) {
            readLine();
        } finally {
            reader.close();
        }
        return 0;
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
