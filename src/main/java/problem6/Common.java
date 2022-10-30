package problem6;

public class Common {
    private static int[][] matrix = new int[20][20];

    static {
        for (int i = 0; i <= 20; i++) {
            matrix[i][0] = 0;
            matrix[0][i] = 0;
        }
    }

    public static boolean isCommon(String name1, String name2) {
        for (int i = 0; i < name1.length(); i++)
            for (int j = 0; j < name2.length(); j++)
                if (constructMatrix(name1, name2, i, j))
                    return true;
        return false;
    }

    private static boolean constructMatrix(String name1, String name2, int i, int j) {
        if (name1.charAt(i) == name2.charAt(j))
            matrix[i][j] = matrix[i - 1][j - 1] + 1;
        return matrix[i][j] >= 2;
    }

}
