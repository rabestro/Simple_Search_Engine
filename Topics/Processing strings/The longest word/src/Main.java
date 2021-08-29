import static java.util.Comparator.comparing;

class Main {
    public static void main(String[] args) {
        new java.util.Scanner(System.in)
                .tokens()
                .max(comparing(String::length))
                .ifPresent(System.out::print);
    }
}
