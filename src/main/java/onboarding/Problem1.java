package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //각 자리 숫자 더하기 값 구하기
    private static int getSum(int num) {
        int ret = 0;

        while(num>0) {
            ret += num % 10;
            num /= 10;
        }

        return ret;
    }

    //각 자리 숫자 곱하기 값 구하기
    private  static int getMultiple(int num) {
        int ret = 1;

        while(num>0) {
            ret *= num % 10;
            num /= 10;
        }

        return ret;
    }
}