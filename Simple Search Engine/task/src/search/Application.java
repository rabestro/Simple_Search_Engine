package search;

import search.ui.TextInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application implements TextInterface, Runnable {
    private List<String> text;

    @Override
    public void run() {
        println("Enter the number of people:");
        final var number = readInt();

        println("Enter all people:");
        text = Stream
                .generate(scanner::nextLine)
                .limit(number)
                .collect(Collectors.toUnmodifiableList());

        println("Enter the number of search queries:");
        final var queries = readInt();
        IntStream.range(0, queries).forEach(i -> search());
    }

    private void search() {
        println("Enter data to search people:");
        final var word = scanner.nextLine().toLowerCase();
        text.stream()
                .filter(line -> line.toLowerCase().contains(word))
                .forEach(this::println);
    }
}
