package operations;

/**
 * @author Birsan Ioana (cas. Amariei) B5
 * @author Gensthaler Octavian B5
 */

public class BasicOperations {
    private static String[] languages = {"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};

    public static void displayInitialMessage() {
        System.out.println("Hello World!");
    }

    public static void displayFinalMessage(int index) {
        System.out.println("Willy-nilly, this semester I will learn " + languages[index]);
    }

    public static int computeResult() {
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;

        return n;
    }

    public static int sumToOnlyOneDigit(int number) {
        while (number > 9) {
            number = sumDigits(number);
        }

        return number;
    }

    public static int sumDigits(int number) {
        if (number < 10) {
            return number;
        } else {
            return (number % 10) + sumDigits(number / 10);
        }
    }

    public static void main(String[] args) {
        displayInitialMessage();
        int result = computeResult();
        int index = sumToOnlyOneDigit(result);
        displayFinalMessage(index);
    }
}
