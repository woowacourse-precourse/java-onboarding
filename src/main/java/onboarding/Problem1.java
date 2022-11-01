package onboarding;

import java.util.List;

/**
 * 기능목록
 * 1. 리스트의 값들이 1초과 400미만 값이 아니거나
 * 첫번째 값이 홀수가 아니고, 두번째 값이 짝수가 아니거나,
 * 서로 하나 이상 차이나면 예외를 터트리는 기능
 * 2. 리스트의 첫번째, 두번째의 각 자릿수들를 더하는 기능
 * 3. 리스트의 첫번째, 두번째의 각 자릿수들를 곱하는 기능
 * 4. 2번과 3번의 값들 중 큰 값을 구하는 기능
 * 5. pobi의 리턴값이 크면 1, crong의 리턴값이 크면 2, 같으면 0을 리턴하는 기능
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (exception(pobi) || exception(crong)) {
            return -1;
        }
        return answer;
    }

    /**
     * 기능목록 1
     * @param check
     * @return 예외에 속하면 true, 속하지 않으면 false
     */
    private static boolean exception(List<Integer> check) {
        if (check.get(0) <= 1 || check.get(0) > 400 || check.get(1) < 1 || check.get(1) >= 400) {
            return true;
        }
        if (check.get(0) % 2 == 0 || check.get(1) % 2 != 0) {
            return true;
        }
        if (check.get(1) - check.get(0) != 1) {
            return true;
        }
        return false;
    }
}