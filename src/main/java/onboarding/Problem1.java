package onboarding;

import java.util.ArrayList;
import java.util.List;
/**
 * 기능 사항
 * a. 예외 처리 체크
 * b. 자릿수 리스트로 변환하는 함수
 * c. 자릿수 별 합과 곱 중 큰 값을 리턴하는 함수
 * d. 기능 요구사항의 연산을 실행하는 함수
 */
class Problem1 {

    /**
     * a. 예외 처리 체크
     *  1. 왼쪽 or 오른쪽 페이지가 null
     *  2. 왼쪽은 홀, 오른쪽은 짝이 아닐 경우
     *  3. 1~400 사이를 벗어날 경우
     *  4. 오른쪽 페이지가 왼쪽 페이지보다 더 클 경우
     * @param list : 에러가 있는지 체크할 list
     * @return 예외면 true, 아니면 false
     */

    static boolean isException(List<Integer> list) {
        Integer left = list.get(0);
        Integer right = list.get(1);
        if (left == null || right == null)
            return true;
        if (!(((left & 1) == 1) && ((right & 1) == 0))) {
            return true;
        }
        if (!(left <= 400 && right <= 400 && left >= 1 && right >= 1)) {
            return true;
        }
        return right - left != 1;
    }

    /**
     * b. 자릿수 리스트로 변환하는 함수
     * @param number
     * @return 자릿수 리스트를 반환
     */
    static List<Integer> integerToList(int number) {
        List<Integer> result = new ArrayList<>();
        while (number != 0) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }

    /**
     * c. 자릿수 별 합과 곱 중 큰 값을 리턴하는 함수
     * @param list
     * @return 해당 값을 연산 후 큰 값 리턴
     */

    static int getMax(List<Integer> list) {
        return Integer.max(list.stream().reduce(0, Integer::sum), list.stream().reduce(1, (a, b) -> a * b));
    }

    /**
     * d. 기능 요구사항의 연산을 실행하여 결과를 리턴하는 함수
     * @param list
     * @return 기능 요구사항의 연산을 실행하여 결과를 리턴
     */

    static int calc(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        List<Integer> leftList = integerToList(left);
        List<Integer> rightList = integerToList(right);

        int leftResult = getMax(leftList);
        int rightResult = getMax(rightList);

        return Integer.max(leftResult, rightResult);
    }

    /**
     * 문제에 대한 정답 함수
     * @param pobi
     * @param crong
     * @return 기능 요구사항 결과를 리턴
     */

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong))
            return -1;
        int resultPobi = calc(pobi);
        int resultCrong = calc(crong);

        if (resultCrong == resultPobi) {
            return 0;
        } else if (resultPobi > resultCrong) {
            return 1;
        } else if (resultPobi < resultCrong) {
            return 2;
        }
        return -1;
    }
}