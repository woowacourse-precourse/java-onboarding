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
        if (exception(pobi) || exception(crong)) {
            return -1;
        }

        int pobiMax = calculateMax(calculateAdd(pobi), calculateMultiply(pobi));
        int crongMax = calculateMax(calculateAdd(crong), calculateMultiply(crong));

        int answer = result(pobiMax, crongMax);

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

    /**
     * 기능목록 2
     * @param list
     * @return list 안의 값들의 각 자릿수들을 모두 더한 값
     */
    private static int calculateAdd(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            int num = list.get(i);
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            result += sum;
        }
        return result;
    }

    /**
     * 기능목록 3
     * @param list
     * @return list 안의 값들의 각 자릿수들을 모두 곱한 값
     */
    private static int calculateMultiply(List<Integer> list) {
        int result = 1;
        for (int i = 0; i < 2; i++) {
            int mult = 1;
            int num = list.get(i);
            while (num > 0) {
                mult *= num % 10;
                num /= 10;
            }
            result *= mult;
        }
        return result;
    }

    /**
     * 기능목록 4
     * @param add
     * @param multiply
     * @return add와 multiply 중 더 큰 값
     */
    private static int calculateMax(int add, int multiply) {

        if (add >= multiply) {
            return add;
        }
        if (add < multiply) {
            return multiply;
        }
        return -1;
    }

    /**
     * 기능목록 5
     * @param pobiMax
     * @param crongMax
     * @return pobi의 리턴값이 크면 1, crong의 리턴값이 크면 2, 같으면 0을 리턴
     */
    private static int result(int pobiMax, int crongMax) {
        if (pobiMax > crongMax) {
            return 1;
        }
        if (pobiMax < crongMax) {
            return 2;
        }
        return 0;
    }
}