package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public String parsePageNumber(int page) {
        return Integer.toString(page);
    }

    public int calculateSumOfStringDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .sum();
    }

    public int calculateMultiplicationOfStringDigits(String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .reduce(1, (ret, digit) -> ret * digit);
    }
}