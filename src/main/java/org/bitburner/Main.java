package org.bitburner;

import org.bitburner.contracts.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started Main");
        int[][] matrix = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0}
        };
        System.out.println(UniquePathsInAGrid.getNumOfWaysToGetToTarget2(matrix,0, 0));
    }
}