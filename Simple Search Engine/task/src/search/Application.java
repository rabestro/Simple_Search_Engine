package search;

import search.ui.Menu;
import search.ui.TextInterface;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application implements TextInterface, Runnable {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");

    private final List<String> text;
    private final Map<String, Set<Integer>> invertedIndex;

    public Application(List<String> text) {
        this.text = text;
        invertedIndex = text.stream()
                .flatMap(WORDS_DELIMITER::splitAsStream)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toUnmodifiableMap(Function.identity(), this::lineNumbers));
    }

    @Override
    public void run() {
        Menu.create("=== Menu ===")
                .add("Find a person", this::search)
                .add("Print all people", () -> text.forEach(this::println))
                .addExit()
                .run();
    }

    private void search() {
        println("Enter data to search people:");
        final var word = scanner.nextLine().toLowerCase();
        final var result = invertedIndex.getOrDefault(word, Collections.emptySet());
        println("{0} persons found:", result.size());
        result.stream().map(text::get).forEach(this::println);
    }

    private Set<Integer> lineNumbers(String word) {
        return IntStream.range(0, text.size())
                .filter(i -> text.get(i).toLowerCase().contains(word))
                .boxed()
                .collect(Collectors.toUnmodifiableSet());
    }

}
