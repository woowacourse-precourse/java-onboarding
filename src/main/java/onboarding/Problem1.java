package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //페이지 번호의 각 자릿수를 모두 더하기, 모두 빼기 한 가장 큰 수 반환
    static int getMaxPageOperationValue(int num) {
        int sum = 0, mul = 1;

        while (num > 0) {
            sum += num % 10;
            mul *= num % 10;
            num /= 10;
        }

        return Math.max(sum, mul);
    }

    //잘못된 페이지인지 확인
    static boolean isWrongPage(int leftPage, int rightPage) {
        return true;
    }
}