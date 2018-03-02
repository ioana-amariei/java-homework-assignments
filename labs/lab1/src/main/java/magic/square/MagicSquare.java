package magic.square;

/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

public class MagicSquare {
    private int n;
    private int[][] square;
    private long magicConstant;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        MagicSquare magicSquare = new MagicSquare();

        magicSquare.readArgumentFromCommandLine(args);
        magicSquare.createMagicSquare();

        if(magicSquare.verifyIfItEqualsMagicConstant()){
            System.out.println("The sum in each row, column and diagonal is equal to the magic constant: " + magicSquare.magicConstant);
        }

        if(magicSquare.n <= 10){
            magicSquare.displayMagicSquareAndConstant();
        } else {
            System.out.println("The magic constant is: " + magicSquare.magicConstant);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(duration + " nanoseconds");
        }

    }

    public void readArgumentFromCommandLine(String[] args) {
        boolean incorrectInput = true;

        while (incorrectInput) {
            if (args.length > 0) {
                try {
                    n = Integer.parseInt(args[0]);
                    if (n % 2 == 0) {
                        System.out.println("Argument must be an odd integer.");
                        System.exit(1);
                    } else {
                        incorrectInput = false;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Argument " + args[0] + " must be an integer.");
                    System.exit(1);
                }
            }
        }
    }

    public void createMagicSquare() {
        square = new int[n][n];
        magicConstant = n * (n * n + 1) / 2;

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[i][j] = n * ((i + j + 1 + n / 2) % n) + (i + 2 * j + 1) % n + 1;
            }
        }
    }

    public String squareToString() {
        StringBuilder stringBuilder = new StringBuilder();
        char unicode = '\u25A2';

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                char c = (char)(unicode + square[i][j]);
                stringBuilder.append(c+ " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean verifyIfItEqualsMagicConstant(){
        return verifyColumnSum() && verifyRowSum() && verifyDiagonalSum();
    }

    private int columnSum(int column) {
        int sum = 0;

        for (int row = 0; row < square.length; row++) {
            sum += square[row][column];
        }
        return sum;
    }

    private int rowSum(int row) {
        int sum = 0;

        for (int column = 0; column < square.length; column++) {
            sum += square[row][column];
        }

        return sum;
    }

    private boolean verifyColumnSum() {
        for (int column = 0; column < square.length; column++) {
            if(columnSum(column) != magicConstant){
                return false;
            }
        }
        return true;
    }

    private boolean verifyDiagonalSum() {
        int sum = 0;

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if (i == j) {
                    sum += square[i][j];
                }
            }
        }

        return sum == magicConstant;
    }

    private boolean verifyRowSum() {
        for (int row = 0; row < square.length; row++) {
            if(rowSum(row) != magicConstant){
                return false;
            }
        }
        return true;
    }

    public void displayMagicSquareAndConstant(){
        System.out.println("Magic constant is: " + magicConstant);
        System.out.println("The square is:");
        System.out.println(squareToString());
    }

}
