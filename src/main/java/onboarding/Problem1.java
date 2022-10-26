package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //각 자리를 더하는 함수
    public static int getSum(int num) {
        int sum = 0;
        while (num < 10) {
            sum += (num % 10);
            num /= 10;
        }
        sum += num;
        return sum;
    }

    //각 자리를 곱하는 함수
    public static int getMultiply(int num) {
        int multiply = 1;
        while (num < 10) {
            multiply *= (num % 10);
            num /= 10;
        }
        multiply *= num;
        return multiply;
    }
}