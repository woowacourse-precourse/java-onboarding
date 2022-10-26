package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    int sumOfDigits(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number%10;
            sum /= 10;
        }
        return sum;
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