package search;

import search.ui.TextInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Main implements TextInterface {

    public static void main(String[] args) throws IOException {
        final var fileName = Path.of(args[1]);
        final var text = Files.lines(fileName).collect(Collectors.toUnmodifiableList());

        new Application(text).run();
    }
}
