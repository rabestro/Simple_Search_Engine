class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int col = twoDimArray[0].length - 1;
        int row = twoDimArray.length - 1;
        System.out.printf("%d %d%n%d %d%n",
                twoDimArray[0][0], twoDimArray[0][col],
                twoDimArray[row][0], twoDimArray[row][col]
        );
    }
}