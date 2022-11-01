package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    //각 자리의 합계 구하는 메서드
    private static int sumOfEachDigit(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    //각 자리의 곱셈의 합계를 구하는 메서드
    private static int multiplicationOfEachDigit(int num) {
        int multi = 1;
        while(num > 0) {
            multi *= num % 10;
            num /= 10;
        }
        return multi;
    }
}