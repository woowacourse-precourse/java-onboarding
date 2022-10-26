package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //입력받은 숫자의 각 자릿수를 더하는 메서드
    private static int sumNum(int num) {
        int result = 0;
        while (num > 0) {
            result += num%10;
            result /= 10;
        }
        return result;
    }

    //입력받은 숫자의 각 자릿수를 곱하는 메서드
    private static int multiplyNum(int num) {
        int result = 1;
        while (num > 0) {
            result = result*(num%10);
            num /= 10;
        }
        return result;
    }

    //입력받은 두 숫자 중 더 큰 수를 반환하는 메서드
    private static int maxNum(int a, int b) {
        int result = 0;
        if (a > b) {
            result = a;
            return result;
        }

        if (a < b) {
            result = b;
            return result;
        }

        if (a == b) {
            result = a;
            return result;
        }
        return result;
    }
}