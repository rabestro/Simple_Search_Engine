package search;

import search.ui.Menu;
import search.ui.TextInterface;

import java.util.List;

public class Application implements TextInterface, Runnable {
    private final List<String> text;

    public Application(List<String> text) {
        this.text = text;
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
        text.stream()
                .filter(line -> line.toLowerCase().contains(word))
                .forEach(this::println);
    }

}
