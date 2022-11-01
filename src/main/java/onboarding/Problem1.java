package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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