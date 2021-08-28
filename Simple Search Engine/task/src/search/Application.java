package search;

import search.ui.Menu;
import search.ui.TextInterface;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.emptySet;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toUnmodifiableSet;

public class Application implements TextInterface, Runnable {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");
    private static final BinaryOperator<Set<Integer>> UNION = (a, b) -> {
        a.addAll(b);
        return a;
    };
    private static final BinaryOperator<Set<Integer>> INTERSECTION = (a, b) -> {
        a.retainAll(b);
        return a;
    };

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
        println("Select a matching strategy: ALL, ANY, NONE");
        final var strategy = scanner.nextLine().toUpperCase();
        println("Enter data to search people:");
        final var data = scanner.nextLine().toLowerCase();

        final var set = WORDS_DELIMITER
                .splitAsStream(data)
                .map(word -> invertedIndex.getOrDefault(word, emptySet()));

        final var result = getLines(strategy, set);

        println("{0} persons found:", result.size());
        result.stream().map(text::get).forEach(this::println);
    }

    private Set<Integer> lineNumbers(String word) {
        return IntStream.range(0, text.size())
                .filter(i -> text.get(i).toLowerCase().contains(word))
                .boxed()
                .collect(toSet());
    }

    private Set<Integer> getLines(String strategy, Stream<Set<Integer>> result) {
        switch (strategy) {
            case "ALL":
                return result.reduce(INTERSECTION).orElse(emptySet());
            case "ANY":
                return result.reduce(UNION).orElse(emptySet());
            case "NONE":
                final var exclude = result.reduce(UNION).orElse(emptySet());
                return IntStream.range(0, text.size()).boxed()
                        .filter(not(exclude::contains))
                        .collect(toUnmodifiableSet());
            default:
                return emptySet();
        }
    }

}
