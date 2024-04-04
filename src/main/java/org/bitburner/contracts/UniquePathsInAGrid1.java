package org.bitburner.contracts;

public class UniquePathsInAGrid1 {
    public static int getNumOfWaysToGetToTarget(int row, int column) {
        if (row == 1 || column == 1) return 1;
        return getNumOfWaysToGetToTarget(row - 1, column) + getNumOfWaysToGetToTarget(row, column - 1);
    }
}
