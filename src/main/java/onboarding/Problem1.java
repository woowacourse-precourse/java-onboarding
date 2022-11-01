package onboarding;

import java.util.List;

/**
 * 기능 목록
 * 1. 예외 사항
 *      1. 페이지가 연속적이지 않을 경우
 *      2. 왼쪽 페이지가 홀수가 아닐 경우
 *      3 .오른쪽 페이지가 짝수가 아닐 경우
 * 2. 각 자리수를 더한 값을 반환하는 기능
 * 3. 각 자리수를 곱한 값을 반환하는 기능
 * 4. max 값을 도출하는 기능
 * 5. pobi와 crong의 승부를 판정하는 기능
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외 사항 - 페이지가 연속적이지 않을 경우
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }

        //예외 사항 - 페이지의 왼쪽이 홀수가 아닐 경우
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) {
            return -1;
        }

        //예외 사항 - 오른쪽 페이지가 짝수가 아닐 경우
        if (pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) {
            return -1;
        }

        return answer;
    }

    public static int sumDigits(int number) {
        int total = 0;
        String stringNumber = Integer.toString(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            total += Character.getNumericValue(stringNumber.charAt(i));
        }
        return total;
    }

}