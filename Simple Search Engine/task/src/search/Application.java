package search;

import search.ui.Menu;
import search.ui.TextInterface;

import java.util.List;
import java.util.stream.Collectors;
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

        Menu.create("=== Menu ===")
                .add("Find a person", this::search)
                .add("Print all people", () -> text.forEach(this::println))
                .addExit()
                .run();
    }

    private void search() {
        println("Enter data to search people:");
        final var word = scanner.nextLine().toLowerCase();
        text.stream()
                .filter(line -> line.toLowerCase().contains(word))
                .forEach(this::println);
    }

}
