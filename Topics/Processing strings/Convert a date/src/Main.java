// Posted from EduTools plugin
class Main {
    public static void main(String[] args) {
        System.out.println(new java.util.Scanner(System.in).next()
                .replaceFirst("(\\d{4})-(\\d\\d)-(\\d\\d)", "$2/$3/$1"));
    }
}