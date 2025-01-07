package org.bitburner.contracts;

import java.util.List;
import java.util.Comparator;

import java.util.stream.*;

public class ShortestPathInAGrid {
//    public static int getNumOfWaysToGetToTarget(int[][] grid, int x, int y, String route) {
//        if (route.endsWith("UD") || route.endsWith("DU") || route.endsWith("LR") || route.endsWith("RL"))
//            return Integer.MAX_VALUE;
//        if (x == grid.length || x == -1 || y == -1 || y == grid[0].length) return Integer.MAX_VALUE;
//        if (grid[x][y] == 1) return Integer.MAX_VALUE;
//        if ((x == grid.length - 1) && (y == grid[0].length - 1)) return 0;
//
//        return Math.min(
//                Math.min(getNumOfWaysToGetToTarget(grid, x + 1, y, route + "R"), getNumOfWaysToGetToTarget(grid, x, y + 1, route + "D")),
//                Math.min(getNumOfWaysToGetToTarget(grid, x - 1, y, route + "L"), getNumOfWaysToGetToTarget(grid, x, y - 1, route + "U"))) + 1;
//    }

    public static String getShortestPathInAGrid(int[][] grid, int x, int y, String route) {
        if (route.endsWith("UD") || route.endsWith("DU") || route.endsWith("LR") || route.endsWith("RL"))
            return "F"; // Infinite loop

        if (isLoopingRoute(route))
            return "F";

        if (x == grid.length || x == -1 || y == -1 || y == grid[0].length) return "F"; // Out of bounds!
        if (grid[x][y] == 1) return "F"; // Don't draw a path using "1"
        if ((x == grid.length - 1) && (y == grid[0].length - 1)) return route; // got to the end of the grid

        String down = getShortestPathInAGrid(grid, x + 1, y, route + "D");
        String right = getShortestPathInAGrid(grid, x, y + 1, route + "R");
        String up = getShortestPathInAGrid(grid, x - 1, y, route + "U");
        String left = getShortestPathInAGrid(grid, x, y - 1, route + "L");

        List<String> paths = Stream.of(right, left, up, down).filter(p -> !p.contains("F")).toList();
        return paths.stream().min(Comparator.comparingInt(String::length)).orElse(route + "F");
    }

    private static boolean isLoopingRoute(String route) {
        for (int i = 0; i < route.length(); i++) {
            String subRoute = route.substring(i);
            int left = (int) (subRoute.chars().filter(ch -> ch == 'L').count());
            int right = (int) (subRoute.chars().filter(ch -> ch == 'R').count());
            int up = (int) (subRoute.chars().filter(ch -> ch == 'U').count());
            int down = (int) (subRoute.chars().filter(ch -> ch == 'D').count());

            if ((left > 0 || right > 0) && (up > 0 || down > 0) && ((left == right && (up == down - 1 || up == down + 1)) || (up == down && (left == right + 1 || left == right - 1))))
                return true;
        }

        return false;
    }
}
