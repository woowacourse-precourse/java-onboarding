package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static final int CONVERT_NUMBER = 48;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외처리
        if (!validate(pobi, crong)) {
            return -1;
        }
        if (getBigScore(pobi) > getBigScore(crong)) {
            return 1;
        }
        if (getBigScore(pobi) < getBigScore(crong)) {
            return 2;
        }
        return 0;
    }

    static boolean validate(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(LEFT_PAGE) == pobi.get(RIGHT_PAGE) - 1 && crong.get(LEFT_PAGE) == crong.get(RIGHT_PAGE) - 1;
    }

    static int getBigScore(List<Integer> pages) {
        int bigScore = 0;
        for (int page : pages) {
            String pageStr = String.valueOf(page);
            char[] pageCharArray = pageStr.toCharArray();
            int digitSum = 0;
            int digitMul = 1;
            for (char digit : pageCharArray) {
                digitSum += (digit - CONVERT_NUMBER);
                digitMul *= (digit - CONVERT_NUMBER);
            }
            if (digitSum >= digitMul && digitSum >= bigScore) {
                bigScore = digitSum;
            }
            if (digitSum <= digitMul && digitMul >= bigScore) {
                bigScore = digitMul;
            }
        }
        return bigScore;
    }
}
