package onboarding;

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


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}