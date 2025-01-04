package org.bitburner.contracts;

public class UniquePathsInAGrid {
    public static int getNumOfWaysToGetToTarget1(int row, int column) {
        if (row == 1 || column == 1) return 1;
        return getNumOfWaysToGetToTarget1(row - 1, column) + getNumOfWaysToGetToTarget1(row, column - 1);
    }

    public static int getNumOfWaysToGetToTarget2(int[][] matrix, int row, int column) {
        if (column == matrix[0].length - 1 && row == matrix.length - 1) return 1;
        if (column == matrix[0].length || row == matrix.length) return 0;
        if (matrix[row][column] == 1) return 0;

        return getNumOfWaysToGetToTarget2(matrix, row + 1, column) + getNumOfWaysToGetToTarget2(matrix,row, column + 1);
    }
}
