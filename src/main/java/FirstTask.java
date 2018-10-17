import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstTask {

    public static void main(String[] args) throws IOException {
        FirstTask firstTask = new FirstTask();
        firstTask.readLine();

    }


    public void readLine() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1st number ");
        String input;
        String input2;
        do {
            input = reader.readLine();
        }
        while (!isDigit(input));

        System.out.println("Enter 2d number ");
        do {
            input2 = reader.readLine();
        }
        while (!isDigit(input2));
        System.out.println(sumNumber(input, input2));
    }


    public boolean isDigit(String input) {
        boolean isAllDigit = input.chars().allMatch(Character::isDigit);
        String s = isAllDigit ? "thx" : "Wrong value";
        System.out.println(s);
        return isAllDigit;
    }

    public String sumNumber(String input1, String input2) {
        int lenght = input1.length() - input2.length();
        StringBuilder input1Builder = new StringBuilder(input1);
        StringBuilder input2Builder = new StringBuilder(input2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.abs(lenght); i++) {
            sb.append("0");
        }

        if (lenght > 0) {
            input2Builder.insert(0, sb);
        }
        if (lenght < 0) {
            input1Builder.insert(0, sb);
        }

        StringBuilder builder = new StringBuilder();
        int local = 0;
        for (int i = input2Builder.length(); i > 0; i--) {
            int i1 = Character.getNumericValue(input1Builder.charAt(i-1));
            int i2 = Character.getNumericValue(input2Builder.charAt(i-1));
            int i3 = (i1 + i2 + local);
            if (i3 > 9) {
                local = 1;
                builder.insert(0, i3 % 10);
            } else {
                local = 0;
                builder.insert(0, i3 % 10);
            }
        }
        if(local == 1){
            builder.insert(0,1);
        }
        return builder.toString();
    }
}
