package onboarding;

import java.util.List;

class Problem1 {
    final static int MIN_PAGE = 1;
    final static int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isLegalPages(List<Integer> pages) {
        return inRange(pages) && isContinuousPages(pages);
    }
    private static boolean isContinuousPages(List<Integer> numbers) {
        return (numbers.get(0) % 2 == 1) && (numbers.get(1) - numbers.get(0) == 1);
    }
    private static boolean inRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_PAGE || number > MAX_PAGE) return false;
        }
        return true;
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
        int[] numbers = new int[str.length()];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = str.charAt(i) -'0';
        }
        return numbers;
    }
}