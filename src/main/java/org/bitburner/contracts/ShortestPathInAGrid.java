package org.bitburner.contracts;

public class ShortestPathInAGrid {
    public static int getNumOfWaysToGetToTarget(int[][] grid, int x, int y, String route) {
        if (route.endsWith("UD") || route.endsWith("DU") || route.endsWith("LR") || route.endsWith("RL")) return Integer.MAX_VALUE;
        if (x == grid.length || x == -1 || y == -1 || y == grid[0].length) return Integer.MAX_VALUE;
        if (grid[x][y] == 1) return Integer.MAX_VALUE;
        if ((x == grid.length - 1) && (y == grid[0].length - 1)) return 0;

        return Math.min(
                Math.min(getNumOfWaysToGetToTarget(grid, x+1, y, route + "R"), getNumOfWaysToGetToTarget(grid, x, y+1, route + "D")),
                Math.min(getNumOfWaysToGetToTarget(grid, x-1, y, route + "L"), getNumOfWaysToGetToTarget(grid, x, y-1, route + "U"))) + 1;
    }

    public static String getNumOfWaysToGetToTarget2(int[][] grid, int y, int x, String route) {
        if (route.endsWith("UD") || route.endsWith("DU") || route.endsWith("LR") || route.endsWith("RL")) return "F"; // Infinite loop
        if (x == grid.length || x == -1 || y == -1 || y == grid[0].length) return "F"; // Out of bounds!
        if (grid[x][y] == 1) return "F"; // Don't draw a path using "1"
        if ((x == grid.length - 1) && (y == grid[0].length - 1)) return ""; // got to the end of the grid

        String right = getNumOfWaysToGetToTarget2(grid, x+1, y, route + "R");
        String down = getNumOfWaysToGetToTarget2(grid, x, y+1, route + "D");
        String left = getNumOfWaysToGetToTarget2(grid, x-1, y, route + "L");
        String up = getNumOfWaysToGetToTarget2(grid, x, y-1, route + "U");

        String shortestPath = "";

        String shortP = "";

        String shortP1 = "";
        if (right.length() < left.length() && !right.contains("F")) shortP = right;
        if (left.length() < right.length() && !left.contains("F")) shortP = left;
        if (up.length() < down.length() && !up.contains("F")) shortP1 = up;
        if (down.length() < up.length() && !down.contains("F")) shortP = down;

        shortestPath = shortP1.length() > 0 && shortP1.length() < shortP.length() ? shortP1 : shortP;

        return shortestPath;

    }
}
