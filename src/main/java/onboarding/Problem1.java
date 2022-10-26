package onboarding;

import java.util.ArrayList;
import java.util.List;
/**
 * 기능 사항
 * 1. 에러 체크
 * 2. 자릿수 리스트로 변환하는 함수
 * 3. 자릿수 별 합과 곱 중 큰 값을 리턴하는 함수
 * 4. 기능 요구사항의 연산을 실행하는 함수
 */
class Problem1 {


    /**
     * 1. 에러 체크
     * @param list : 에러가 있는지 체크할 list
     * @return error가 있을 경우 true, 없을경우 false
     */

    static boolean checkError(List<Integer> list) {
        if (list.get(0) == null || list.get(1) == null)
            return true;
        if (!(((list.get(0) & 1) == 1) && ((list.get(1) & 1) == 0))) {
            return true;
        }
        if (!(list.get(0) <= 400 && list.get(1) <= 400 && list.get(0) >= 1 && list.get(1) >= 1)) {
            return true;
        }
        return list.get(1) - list.get(0) != 1;
    }

    /**
     * 2. 자릿수 리스트로 변환하는 함수
     * @param x
     * @return 자릿수 리스트를 반환
     */
    static List<Integer> intToList(int x) {
        List<Integer> result = new ArrayList<>();
        while (x != 0) {
            result.add(x % 10);
            x /= 10;
        }

        return result;
    }

    /**
     * 3. 자릿수 별 합과 곱 중 큰 값을 리턴하는 함수
     * @param list
     * @return 해당 값을 연산 후 큰 값 리턴
     */

    static int getMax(List<Integer> list) {
        return Integer.max(list.stream().reduce(0, Integer::sum), list.stream().reduce(1, (a, b) -> a * b));
    }

    /**
     * 4. 기능 요구사항의 연산을 실행하여 결과를 리턴하는 함수
     * @param list
     * @return 기능 요구사항의 연산을 실행하여 결과를 리턴
     */

    static int calc(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);
        List<Integer> leftList = intToList(left);
        List<Integer> rightList = intToList(right);
        int leftResult = getMax(leftList);
        int rightResult = getMax(rightList);
        return Integer.max(leftResult, rightResult);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}