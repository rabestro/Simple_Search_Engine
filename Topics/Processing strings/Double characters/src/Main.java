class Main {
    public static void main(String[] args) {
        System.out.print(
		    new java.util.Scanner(System.in)
		        .nextLine()
		        .replaceAll("(.)", "$1$1")
        );
    }
}
