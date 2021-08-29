import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var word = scanner.next();
        final var n = scanner.nextInt();
        scanner.close();
		
        if (n < word.length()) {
            System.out.print(word.substring(n, word.length()) + word.substring(0, n));
        } else {
            System.out.print(word);
        }
    }
}
