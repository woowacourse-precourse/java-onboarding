package onboarding;

import java.util.List;

class Problem1 {
    final static int MIN_PAGE = 1;
    final static int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    int sumOfDigits(int[] numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }

    boolean isContinuousPages(List<Integer> numbers) {
        return (numbers.get(0) % 2 == 1) && (numbers.get(1) - numbers.get(0) == 1);
    }
    boolean inRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_PAGE || number > MAX_PAGE) return false;
        }
        return true;
    }

    int mulOfDigits(int[] numbers) {
        int mul = 1;
        for(int number : numbers) {
            mul *= number;
        }
        return mul;
    }

    int[] toIntArray(int number) {
        String str = String.valueOf(number);
        int[] numbers = new int[str.length()];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = str.charAt(i) -'0';
        }
        return numbers;
    }
}