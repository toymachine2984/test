import java.util.Random;

public class ThridTask {

    private int winCount = 5;
    private int stepCount = 45;
    private String matrix[][] = new String[10][10];

    public static void main(String[] args) {
        ThridTask task = new ThridTask();
        task.fill();
        task.generate("X");
        task.generate("O");
        task.sout();
        task.isDiagonalsCountEnough(9,9,"X");
    }


    public void generate(String value) {
        Random random = new Random();
//        int currentStep = value.equals("X") ? stepCount - 1 : stepCount; fixme is Alice goes first?
        int currentStep = stepCount;
        do {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
//            if (isEmpty(x, y) && check(x, y, value) && check(x, y, value)) {
            if (isEmpty(x, y) && isHWCountEnough(x, y, value)) {
                matrix[x][y] = value;
            } else {
                currentStep++;
            }
        } while ((--currentStep) > 0);
    }

    public boolean check(int row, int position, String value) {
        return isDiagonalsCountEnough(row, position, value) && isHWCountEnough(row, position, value);
    }

    private boolean isDiagonalsCountEnough(int row, int position, String value) {
        return (checkD1(row, position, value) && checkD2(row, position, value));
    }

    private boolean isHWCountEnough(int row, int position, String value) {
        return checkHW(row, position, value, true) && checkHW(row, position, value, false);
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
     * direction = true ->  by horizontally
     * direction = false ->  by diagonally
     */
    public boolean checkHW(int rowOrColumn, int position, String value, boolean direction) {
        int rightCount = 0;
        int leftCount = 0;
        int elementPosition = position;
        int directionCheck = rowOrColumn;
        if (!direction) {
            elementPosition = rowOrColumn;
            directionCheck = position;
        }


        for (int j = directionCheck; j < matrix[elementPosition].length - 1; j++) {
            if (matrix[elementPosition][j + 1].equals(value)) {
                rightCount++;
            } else {
                break;
            }
        }
        for (int j = directionCheck; j > 0; j--) {
            if (matrix[elementPosition][j - 1].equals(value)) {
                leftCount++;
            } else {
                break;
            }
        }
        return (rightCount + leftCount) <= (winCount - 1);
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
    private void fill() {
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
        for (int i = row; i < matrix.length - 1; i++, j++) {
            if (matrix[i + 1][j + 1].equals(value)) {
                toBottomRightCount++;
            } else break;
        }

        j = position;
        for (int i = row; i > 1; i--, j--) {
            if (matrix[i - 1][j - 1].equals(value)) {
                toTopLeftCount++;

            } else break;
        }
        return (toBottomRightCount + toTopLeftCount) <= (winCount - 1);
    }

    /**
     * Check diagonal
     * Check is current position being win
     */
    private boolean checkD2(int row, int position, String value) {
        int toBottomLeftCount = 0;
        int toTopRightCount = 0;
        int j = position;

        for (int i = row; i < matrix.length -1; i++, j--) {
            if (matrix[i + 1][j - 1].equals(value)) {
                toBottomLeftCount++;
            } else break;
        }

        j = position;

        for (int i = row; i > 1; i--, j++) {
            if (matrix[i - 1][j + 1].equals(value)) {
                toTopRightCount++;
            } else break;
        }
        return (toBottomLeftCount + toTopRightCount) <= (winCount - 1);
    }

}
