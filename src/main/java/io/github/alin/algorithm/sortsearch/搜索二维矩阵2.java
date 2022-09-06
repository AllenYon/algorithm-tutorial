package io.github.alin.algorithm.sortsearch;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class 搜索二维矩阵2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 16));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return dfs(matrix, 0, matrix[0].length - 1, target);
    }

    public static boolean dfs(int[][] matrix, int i, int j, int target) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] < target) {
            return dfs(matrix, i + 1, j, target);
        } else {
            return dfs(matrix, i, j - 1, target);
        }
    }
}
