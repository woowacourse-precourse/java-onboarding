package onboarding;

import java.util.List;

class Problem1 {
    /*
        기능 요구 사항 목록
        1. 예외사항 확인 함수
        2. 자릿수 합과 곱 중 큰 값을 반환하는 함수
        3. solution (왼쪽·오른쪽 비교, 승자 선정)
    */

    // 예외사항 확인 함수
    private static boolean correctGiven(List<Integer> given) {
        // 연속적인 수가 주어졌는지 확인
        if (given.get(0) + 1 != given.get(1))
            return false;

        // 첫 면, 마지막 면이 주어졌는지 확인
        for (int i : given) {
            if ((i == 1) || (i == 400))
                return false;
        }

        return true;
    }

    // 자릿수 합과 곱 중 큰 값을 반환하는 함수
    private static int sumOrProduct(int number) {
        int addResult = 0;
        int multiplyResult = 1;

        String numString = Integer.toString(number);
        for (int i = 0; i < numString.length(); i++) {
            char digitChar = numString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            addResult += digit;         // 덧셈
            multiplyResult *= digit;    // 곱셈
        }

        return Math.max(addResult, multiplyResult);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}