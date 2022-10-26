package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getAddDigitsResult(int pageNumber) {
        int addResult = 0;

        while (pageNumber != 0) {
            addResult += pageNumber % 10;
            pageNumber /= 10;
        }
        return addResult;
    }

    private static int getMultiplyDigitsResult(int pageNumber) {
        int multiplyResult = 1;
        while (pageNumber != 0) {
            multiplyResult *= pageNumber % 10;
            pageNumber /= 10;
            if (pageNumber == 0) {
                break;
            }
        }
        return multiplyResult;
    }
}