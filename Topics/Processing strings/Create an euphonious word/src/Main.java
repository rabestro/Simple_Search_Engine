// Posted from EduTools plugin
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String word = sc.next().toLowerCase();

        final int result = Arrays
                .stream(word.split("((?<=[aeiouy])(?=[^aeiouy]))|((?<=[^aeiouy])(?=[aeiouy]))"))
                .mapToInt(s -> (s.length() - 1) / 2).sum();

        System.out.println(result);
    }
}