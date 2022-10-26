package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static String parsePageNumber(int page) {
        return Integer.toString(page);
    }

    public static int calculateSumOfStringDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public static int calculateMultiplicationOfStringDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .reduce(1, (ret, digit) -> ret * digit);
    }

    public static int getPlayerMaxScore(List<Integer> player) {
        int leftPageMaxScore = getPageMaxScore(player.get(LEFT_PAGE));
        int rightPageMaxScore = getPageMaxScore(player.get(RIGHT_PAGE));

        return Math.max(leftPageMaxScore, rightPageMaxScore);
    }

    public static int getPageMaxScore(int page) {
        String parsedPageNumber = parsePageNumber(page);
        int sumResult = calculateSumOfStringDigits(parsedPageNumber);
        int multiplicationResult = calculateMultiplicationOfStringDigits(parsedPageNumber);

        return Math.max(sumResult, multiplicationResult);
    }
}