import java.util.Scanner;

public class Main {

    public static long factorial(final long n) {
        long f = 1;
        for (long i = n; i > 1; --i) {
            f *= i;
        }
        return f;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}