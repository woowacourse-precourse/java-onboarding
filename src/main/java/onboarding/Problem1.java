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
}