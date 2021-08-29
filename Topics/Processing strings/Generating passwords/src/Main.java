import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		final var sc = new Scanner(System.in);
		final int a = sc.nextInt();
		final int b = sc.nextInt();
		final int c = sc.nextInt();
		final int n = sc.nextInt();
		sc.close();

		System.out.println(generatePassword(a, b, c, n));
	}

	static String generatePassword(int a, int b, int c, int n) {
		final var twoConsequentChars = Pattern.compile("(.)\\1");
		final var random = new Random();
		StringBuilder password;

		do {
			final var list = Stream.of(
					random.ints(a, 'A', 'Z' + 1),
					random.ints(b, 'a', 'z' + 1),
					random.ints(c, '0', '9' + 1),
					random.ints(n - a - b - c, '0', 'z' + 1))
					.flatMapToInt(i -> i).boxed().collect(Collectors.toList());
					
			Collections.shuffle(list);
			
			password = list.stream().collect(
                StringBuilder::new, 
                StringBuilder::appendCodePoint, 
                StringBuilder::append);
					
		} while (twoConsequentChars.matcher(password).find());

		return password.toString();
	}
}
