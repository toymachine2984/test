import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ThridTask {

    private int winCount = 5;
    private int stepCount = 49;
    private String matrix[][] = new String[10][10];

    public ThridTask(int stepCount) {

        this.stepCount = stepCount;
        this.fill();
    }

    public ThridTask() {

    }

    public ThridTask(String[][] m) {
        this.matrix = m;
    }


    public static void main(String[] args) {
        ThridTask task = new ThridTask();
        task.fillMatirx();
        task.sout();
        System.out.println(task.isCanWin(("X")));
    }


    public void fillMatirx() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Start ");
            String input;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    boolean isCorrect = false;
                    do {
                        input = reader.readLine();
                        if (input.equals(".") || input.equals("X") || input.equals("O")) {
                            if (!input.equals(".")) {
                                if (check(i, j, input)) {
                                    isCorrect = true;
                                    matrix[i][j] = input;
                                    sout();
                                } else {
                                    isCorrect = false;
                                    System.out.println("Wrong position \r\n pls try again");
                                }
                            } else {
                                isCorrect = true;
                                matrix[i][j] = input;
                                sout();
                            }
                        } else {
                            System.out.println("wrong value \r\npls try again");
                            isCorrect = false;
                        }
                    } while (!isCorrect);
                    System.out.println("next value");
                }

            }
            System.out.println(isCanWin("X"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String  isCanWin(String value) {
        boolean isWin = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(".")) {
                    isWin = !check(i, j, value);
                    if(isWin)return "YES";
                }
            }
        }
        return "NO";
    }


    private boolean check(int row, int position, String value) {
        return isDiagonalsCountEnough(row, position, value) && isHWCountEnough(row, position, value);
    }

    private boolean isDiagonalsCountEnough(int row, int position, String value) {
        return (checkD1(row, position, value) && checkD2(row, position, value));
    }

    private boolean isHWCountEnough(int row, int position, String value) {
        return checkH(row, position, value) && checkW(row, position, value);
    }

    public void sout() {
        for (String[] aMatrix : matrix) {
            for (String anAMatrix : aMatrix) {
                System.out.print(anAMatrix);
            }
            System.out.println();
        }
    }

    /**
     * is win position
     * by diagonally
     */
    private boolean checkW(int row, int position, String value) {
        int bCount = 0;
        int tCount = 0;
        for (int i = row; i < matrix.length - 1; i++) {
            if (matrix[i + 1][position].equals(value)) {
                bCount++;
            } else
                break;

        }
        for (int i = row; i > 0; i--) {
            if (matrix[i - 1][position].equals(value)) {
                tCount++;
            } else break;
        }
        return (bCount + tCount) < (winCount - 1);
    }

    /**
     * is win position
     * by horizontally
     */
    private boolean checkH(int row, int position, String value) {
        int rightCount = 0;
        int leftCount = 0;

        for (int j = position; j < matrix[position].length - 1; j++) {
            if (matrix[row][j + 1].equals(value)) {
                rightCount++;
            } else break;

        }
        for (int j = position; j > 0; j--) {
            if (matrix[row][j - 1].equals(value)) {
                leftCount++;
            } else break;

        }
        return (rightCount + leftCount) < (winCount - 1);
    }


    /**
     * is current position empty
     */
    private boolean isEmpty(int row, int position) {
        return matrix[row][position].equals(".");
    }

    /**
     * Fill empty array by default value (".")
     */
    public void fill() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ".";
            }
        }
    }


    /**
     * Check diagonal
     * Check is current position being win
     */
    private boolean checkD1(int row, int position, String value) {
        int toBottomRightCount = 0;
        int toTopLeftCount = 0;
        int j = position;
        for (int i = row; (i < matrix.length - 1) && (j < matrix.length - 1); i++, j++) {
            if (matrix[i + 1][j + 1].equals(value)) {
                toBottomRightCount++;
            } else break;
        }

        j = position;
        for (int i = row; (i > 0) && (j > 0); i--, j--) {
            if (matrix[i - 1][j - 1].equals(value)) {
                toTopLeftCount++;

            } else break;
        }
        return (toBottomRightCount + toTopLeftCount) < (winCount - 1);
    }

    /**
     * Check diagonal
     * Check is current position being win
     */
    private boolean checkD2(int row, int position, String value) {
        int toBottomLeftCount = 0;
        int toTopRightCount = 0;
        int j = position;

        for (int i = row; (i < matrix.length - 1) && (j > 0); i++, j--) {
            if (matrix[i + 1][j - 1].equals(value)) {
                toBottomLeftCount++;
            } else break;
        }

        j = position;

        for (int i = row; (i > 1) && (j < matrix.length - 1); i--, j++) {
            if (matrix[i - 1][j + 1].equals(value)) {
                toTopRightCount++;
            } else break;
        }
        return (toBottomLeftCount + toTopRightCount) < (winCount - 1);
    }


    public void generate(String value) {
        Random random = new Random();
//        int currentStep = value.equals("X") ? stepCount - 1 : stepCount; fixme is Alice goes first?
        int currentStep = stepCount;
        do {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (isEmpty(x, y) && check(x, y, value)) {
                matrix[x][y] = value;
            } else {
                currentStep++;
            }
        } while ((--currentStep) > 0);
    }
}
