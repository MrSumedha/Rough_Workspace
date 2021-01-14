package algo.DP;

public class MinCostPathMatrix {

    private static int minPath(int[][] input, int rows, int cols) {
        int[][] mat = new int[rows][cols];
        mat[0][0] = input[0][0];
        for (int i = 1; i < rows; i++) {
            mat[i][0] = mat[i - 1][0] + input[i][0];
        }
        for (int j = 1; j < cols; j++) {
            mat[0][j] = mat[0][j - 1] + input[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + input[i][j];
            }
        }
        printMatrix(mat, 3, 4);
        return mat[rows - 1][cols - 1];
    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3, 5, 8}, {4, 2, 1, 7}, {4, 3, 2, 3}};
        printMatrix(input, 3, 4);
        System.out.println("===================================\n");
        System.out.println("Minimum path = " + minPath(input, 3, 4));
    }
}
