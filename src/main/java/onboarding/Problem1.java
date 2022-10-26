package onboarding;

import java.util.List;

class Problem1 {
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