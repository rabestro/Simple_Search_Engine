import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

class Main {
    static final Pattern PARAMETER = Pattern.compile("(\\w+)=([^&]*)");
    static final Pattern PASSWORD = Pattern.compile("pass=([^&]*)");

    public static void main(String[] args) {
        final var url = new Scanner(System.in).nextLine();

        PARAMETER.matcher(url).results().forEach(Main::printParameter);
        PASSWORD.matcher(url).results().forEach(Main::printPassword);
    }

    static void printParameter(MatchResult result) {
        var key = result.group(1);
        var val = result.group(2);
        System.out.print(key + " : ");
        System.out.println(val.isEmpty() ? "not found" : val);
    }

    static void printPassword(MatchResult result) {
        System.out.println("password : " + result.group(1));
    }

}