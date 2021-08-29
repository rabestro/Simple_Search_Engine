import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        var sc = new java.util.Scanner(System.in);
        var string = sc.nextLine();
        var substring = sc.nextLine();
        var count = Pattern.compile(substring)
                .matcher(string)
                .results()
                .count();
        System.out.println(count);
    }
}
