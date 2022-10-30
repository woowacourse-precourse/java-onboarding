package problem6;

public class Common {
    private static int[][] matrix = new int[20][20];

    static {
        for (int i = 0; i < 20; i++) {
            matrix[i][0] = 0;
            matrix[0][i] = 0;
        }
    }

    public static boolean isCommon(String name1, String name2) {
        int length1 = name1.length();
        int length2 = name2.length();
        for (int i = 1; i <= length1; i++)
            for (int j = 1; j <= length2; j++)
                if (twoSameSequential(name1, name2, i, j))
                    return true;
        return false;
    }

    private static boolean twoSameSequential(String name1, String name2, int i, int j) {
        if (name1.charAt(i-1) == name2.charAt(j-1))
            matrix[i][j] = matrix[i - 1][j - 1] + 1;
        else
            matrix[i][j] = 0;
        return matrix[i][j] >= 2;
    }

}
