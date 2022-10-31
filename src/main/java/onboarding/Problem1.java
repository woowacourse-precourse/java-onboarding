package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;

        if (!isValid(pobi, crong)) {
            return -1;
        }

        pobiScore = calculateMaxScore(pobi);
        crongScore = calculateMaxScore(crong);
        return checkWinner(pobiScore, crongScore);
    }

    private static boolean isValid(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2) {
            return false;
        }
        if (pobi.get(0) < 3 || pobi.get(0) > 397 || pobi.get(1) < 4 || pobi.get(1) > 398) {
            return false;
        }
        if (crong.get(0) < 3 || crong.get(0) > 397 || crong.get(1) < 4 || crong.get(1) > 398) {
            return false;
        }
        if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1 || crong.get(0) % 2 == 0 || crong.get(1) % 2 == 1) {
            return false;
        }
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return false;
        }
        return true;
    }

    private static int calculateMaxScore(List<Integer> human) {
        int maxScore = Integer.MIN_VALUE;
        int tempScore;

        for (int i = 0; i < 2; ++i) {
            tempScore = 0;
            for (int value = human.get(i); value != 0; value /= 10){
                tempScore += value % 10;
            }
            maxScore = (maxScore < tempScore) ? tempScore : maxScore;
        }

        for (int i = 0; i < 2; ++i) {
            tempScore = 1;
            for (int value = human.get(i); value != 0; value /= 10){
                tempScore *= value % 10;
            }
            maxScore = (maxScore < tempScore) ? tempScore : maxScore;
        }

        return maxScore;
    }

    private static int checkWinner(int scoreA, int scoreB) {
        return (scoreA == scoreB) ? 0 : ((scoreA > scoreB) ? 1 : 2);
    }
}