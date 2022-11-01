package onboarding;

import java.util.List;

class Problem1 {
    private static final Integer EXCEPTION = -1;
    private static final Integer POBI_WIN = 1;
    private static final Integer CRONG_WIN = 2;
    private static final Integer TIE = 0;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validatePages(pobi);
            validatePages(crong);
        } catch (IllegalArgumentException e) {
            return EXCEPTION;
        }

        int pobiScore = Math.max(findMaxScore(pobi.get(0)), findMaxScore(pobi.get(1)));
        int crongScore = Math.max(findMaxScore(crong.get(0)), findMaxScore(crong.get(1)));

        if (pobiScore == crongScore) {
            return TIE;
        }
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        return CRONG_WIN;
    }

    public static void validatePages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (leftPage < 1 || rightPage > 400 || rightPage - leftPage != 1) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    public static int findMaxScore(int page) {
        int sumOfPageDigit = 0;
        int multiplicationOfPageDigit = 1;

        String pageNumber = String.valueOf(page);
        for (int i = 0; i < pageNumber.length(); i++) {
            int digit = pageNumber.charAt(i) - '0';
            sumOfPageDigit += digit;
            multiplicationOfPageDigit *= digit;
        }

        return Math.max(sumOfPageDigit, multiplicationOfPageDigit);
    }
}