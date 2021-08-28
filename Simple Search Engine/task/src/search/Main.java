package search;

import search.ui.TextInterface;

import java.util.regex.Pattern;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Main implements TextInterface {
    private static final Pattern SPACE = Pattern.compile("\\s+");

    public static void main(String[] args) {
        final var line = scanner.nextLine();
        final var word = scanner.nextLine();
        final var words = SPACE.splitAsStream(line).collect(toUnmodifiableList());
        final var index = words.indexOf(word);

        if (index < 0) {
            System.out.println("Not found");
        } else {
            System.out.println(index + 1);
        }
    }
}
