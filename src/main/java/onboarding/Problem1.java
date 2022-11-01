package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        if (!isValidPages(pobi) || !isValidPages(crong)) {
            return answer;
        }

        int pobiScore = calcMaxScoreInPages(pobi);
        int crongScore = calcMaxScoreInPages(crong);
        if (pobiScore < crongScore) {
            answer = 2;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static boolean isValidPages(List<Integer> pages) {
        boolean isNearBy = pages.get(0) + 1 == pages.get(1);
        boolean isOdd = pages.get(0) % 2 == 1;
        boolean isValidRange = pages.get(0) >= 1 && pages.get(0) < 400
                && pages.get(1) >= 1 && pages.get(1) < 400;

        return isNearBy && isOdd && isValidRange;
    }

    private static int calcMaxScoreInPages(List<Integer> pages) {
        int leftScore = calcMaxScore(pages.get(0));
        int rightScore = calcMaxScore(pages.get(1));
        return Integer.max(leftScore, rightScore);
    }

    private static int calcMaxScore(Integer page) {
        int multiValue = 1;
        int sumValue = 0;
        while (page != 0) {
            int digit = page % 10;
            multiValue *= digit;
            sumValue += digit;
            page /= 10;
        }

        return Integer.max(multiValue, sumValue);

    }
}