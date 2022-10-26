package onboarding;

import java.util.List;

class Problem1 {

    /**
     * 두 페이지 수가 연속되었는지 확인한다.
     * @param input
     * @return
     */
    private static boolean isException(List<Integer> input) {
        if (input.get(0) % 2 != 1 || input.get(1) % 2 != 0) return true;
        if (input.get(1) - input.get(0) != 1) return true;
        if (input.get(0) <= 1 || input.get(1) >= 400) return true;
        return false;
    }

    /**
     * 주어진 정수의 각 자리수를 더한 값을 리턴한다.
     * @param input
     * @return
     */
    private static int addIntegers(int input) {
        int answer = 0;

        while(input >= 10) {
            answer += input % 10;
            input /= 10;
        }
        answer += input;

        return answer;
    }

    /**
     * 주어진 정수의 각 자리수를 곱한 값을 리턴한다.
     * @param input
     * @return
     */
    private static int multiplyIntegers(int input) {
        int answer = 1;

        while(input >= 10) {
            answer *= input % 10;
            input /= 10;
        }
        answer *= input;

        return answer;
    }

    /**
     * 펼쳐진 두 페이지에서 얻을 수 있는 가장 큰 점수를 찾는다.
     * @param input
     * @return
     */
    private static int getMaxScore(List<Integer> input) {
        // 왼쪽 번호의 각 자리 수를 모두 더한다.
        int leftAdd = addIntegers(input.get(0));
        // 왼쪽 번호의 각 자리 수를 모두 곱한다.
        int leftMultipy = multiplyIntegers(input.get(0));
        // 오른쪽 번호의 각 자리 수를 모두 더한다.
        int rightAdd = addIntegers(input.get(1));
        // 오른쪽 번호의 각 자리 수를 모두 곱한다.
        int rightMultiply = multiplyIntegers(input.get(1));

        return max(max(leftAdd, leftMultipy), max(rightAdd, rightMultiply));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}