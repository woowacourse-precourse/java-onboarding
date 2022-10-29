package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 각 자리 숫자 더하기
    public static int getSum(int page) {
        int sum = 0;
        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }
    // 각 자리 숫자 곱하기
    public static int getMultiply(int page) {
        int multiplication = 0;
        while(page > 0) {
            multiplication *= page % 10;
            page /= 10;
        }
        return multiplication;
    }

}

