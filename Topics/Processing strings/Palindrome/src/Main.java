class Main {
    public static void main(String[] args) {
        String word = new java.util.Scanner(System.in).next();
        boolean isPalindrome = new StringBuilder(word).reverse().toString().equals(word);
        System.out.println(isPalindrome?"yes":"no");
    }
}
