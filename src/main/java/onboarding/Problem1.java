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

    //두 숫자 크기를 비교하여 큰 값을 반환하는 함수
    public static int getBigNumber(int sum, int multiply){
        if(sum==multiply || sum>multiply) return sum;
        return multiply;
    }
}