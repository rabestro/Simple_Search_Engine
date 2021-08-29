// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String genomeSequence = sc.next().toLowerCase();
        sc.close();

        final double percentage = 100. * genomeSequence.replaceAll("[^cg]", "").length() / genomeSequence.length();

        System.out.println(percentage);
    }
}