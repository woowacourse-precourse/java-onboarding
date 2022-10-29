package onboarding;

import java.util.List;

class Problem1 {
    private static final int fisrtPage = 1;
    private static final int lastPage = 400;

    interface CalculateNum {
        Integer calculate(List<Integer> pages);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(validateInput(pobi) && validateInput(crong))) {
            return -1;
        }

        List<CalculateNum> calculations = List.of(Problem1::firstMethod, Problem1::secondMethod);
        int pobiScore = calculateScore(pobi, calculations);
        int crongScore = calculateScore(crong, calculations);

        if (pobiScore == crongScore) {
            answer = 0;
        } else if (pobiScore > crongScore){
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }

    private static int calculateScore(List<Integer> pages, List<CalculateNum> calculations) {
        int result = 0;
        for (CalculateNum cal : calculations) {
            int number = cal.calculate(pages);
            if (result < number) {
                result = number;
            }
        }

        return result;
    }

    private static boolean validateInput(List<Integer> input) {
        if (Math.abs(input.get(0) - input.get(1)) != 1) {
            return false;
        }

        for (Integer page : input) {
            if (page <= fisrtPage || lastPage <= page) {
                return false;
            }
        }

        return true;
    }

    private static int firstMethod(List<Integer> pages) {
        int numAdded = 0, numMultiplied = 1;
        int targetPage = pages.get(0);

        while (targetPage != 0) {
            int num = targetPage % 10;
            numAdded += num;
            numMultiplied *= num;
            targetPage /= 10;
        }

        return Math.max(numAdded, numMultiplied);
    }

    private static int secondMethod(List<Integer> pages) {
        int numAdded = 0, numMultiplied = 1;
        int targetPage = pages.get(1);

        while (targetPage != 0) {
            int num = targetPage % 10;
            numAdded += num;
            numMultiplied *= num;
            targetPage /= 10;
        }

        return Math.max(numAdded, numMultiplied);
    }
}