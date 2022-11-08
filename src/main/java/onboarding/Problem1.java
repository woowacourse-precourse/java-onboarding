package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    final static int MIN_PAGE = 1;
    final static int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isLegalPages(pobi) || !isLegalPages(crong)) {
            return -1;
        }

        int pobiScore = getPageMaxScore(pobi);
        int crongScore = getPageMaxScore(crong);

        if(pobiScore > crongScore) {
            return 1;
        }

        if(crongScore > pobiScore) {
            return 2;
        }

        return 0;
    }

    private static boolean isLegalPages(List<Integer> pages) {
        return inRange(pages) && isContinuousPages(pages);
    }

    private static boolean inRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number <= MIN_PAGE || number >= MAX_PAGE) return false;
        }
        return true;
    }

    private static boolean isContinuousPages(List<Integer> numbers) {
        if (numbers.get(0) % 2 != 1) {
            return false;
        }
        if (numbers.get(1) - numbers.get(0) != 1) {
            return false;
        }
        return true;
    }

    private static int getPageMaxScore(List<Integer> pages) {
        int leftMax = getMaxScore(pages.get(0));
        int rightMax = getMaxScore(pages.get(1));
        return Math.max(leftMax, rightMax);
    }

    private static int getMaxScore(int number) {
        return Math.max(sumOfDigits(toIntArray(number)), mulOfDigits(toIntArray(number)));
    }
    private static int sumOfDigits(int[] numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int mulOfDigits(int[] numbers) {
        int mul = 1;
        for(int number : numbers) {
            mul *= number;
        }
        return mul;
    }

    private static int[] toIntArray(int number) {
        String str = String.valueOf(number);
        int[] numbers = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        return numbers;
    }
}