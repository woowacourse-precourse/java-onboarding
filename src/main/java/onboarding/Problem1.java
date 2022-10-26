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

    private static int getLeftPageMaximum(List<Integer> pageList) {
        int maximumResult = 0;
        maximumResult = Math.max(getAddDigitsResult(pageList.get(0)), getMultiplyDigitsResult(pageList.get(0)));
        return maximumResult;
    }

    private static int getRightPageMaximum(List<Integer> pageList) {
        int maximumResult = 0;
        maximumResult = Math.max(getAddDigitsResult(pageList.get(1)), getMultiplyDigitsResult(pageList.get(1)));
        return maximumResult;
    }
}