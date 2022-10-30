package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int scorePobi = maxScore(List.of(add(pobi.get(0)), multiply(pobi.get(0)), add(pobi.get(1)), multiply(pobi.get(1))));
        int scoreCrong = maxScore(List.of(add(crong.get(0)), multiply(crong.get(0)), add(crong.get(1)), multiply(crong.get(1))));

        return answer;
    }

    private static int add(int pageNumber) {
        int result = 0;
        while (pageNumber > 0) {
            result += pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    private static int multiply(int pageNumber) {
        int result = 1;
        while (pageNumber > 0) {
            result *= pageNumber % 10;
            pageNumber /= 10;
        }
        return result;
    }

    private static int maxScore(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElse(-1);
    }
}