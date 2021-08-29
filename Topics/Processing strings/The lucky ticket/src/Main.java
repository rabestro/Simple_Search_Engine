// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        final var sc = new Scanner(System.in);
        final var number = sc.next();
        sc.close();

        final var isLucky = number.chars().limit(3).map(Character::getNumericValue).sum()
                == number.chars().skip(3).map(Character::getNumericValue).sum();

        System.out.println(isLucky ? "Lucky" : "Regular");
    }
}