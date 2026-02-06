public class Assignment {
    static void Transpose(){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose Matrix:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void Rotation(){
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] rotated = new int[2][2];

        rotated[0][0] = matrix[1][0];
        rotated[0][1] = matrix[0][0];
        rotated[1][0] = matrix[1][1];
        rotated[1][1] = matrix[0][1];

        System.out.println("Rotated Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void multiplication(){
        int[][] A = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] B = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        int[][] result = new int[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Result of Multiplication:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void flip(){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        int rows = 4, cols = 3;

        System.out.println("Horizontally Flipped Matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void main() {
        Assignment.Transpose();
        System.out.println();

        Assignment.Rotation();
        System.out.println();

        Assignment.multiplication();
        System.out.println();

        Assignment.flip();
        System.out.println();
    }
}
