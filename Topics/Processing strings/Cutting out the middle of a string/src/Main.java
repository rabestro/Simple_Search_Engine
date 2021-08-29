class Main {
    public static void main(String[] args) {
        var sb = new StringBuilder(new java.util.Scanner(System.in).nextLine());
        System.out.print(sb.delete((sb.length() - 1) / 2, 1 + sb.length() / 2));
    }
}
