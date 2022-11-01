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

        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiScore = getMaxNumber(pobi);
        int crongScore = getMaxNumber(crong);

        return judgeGame(pobiScore, crongScore);
    }

    private static int judgeGame(int pobiScore, int crongScore) {
        int answer = 0;

        if (pobiScore < crongScore) {
            answer = 2;
        } else if (crongScore < pobiScore) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }

    private static boolean isException(List<Integer> member) {
        boolean result = false;

        //예외 사항 - 페이지가 연속적이지 않을 경우
        if (member.get(1) - member.get(0) != 1) {
            result = true;
        }

        //예외 사항 - 페이지의 왼쪽이 홀수가 아니거나, 오른쪽이 짝수가 아닐 경우
        if (member.get(0) % 2 != 1 || member.get(1) % 2 != 0) {
            result = true;
        }

        return result;
    }

    private static int sumDigits(int number) {
        int total = 0;
        String stringNumber = Integer.toString(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            total += Character.getNumericValue(stringNumber.charAt(i));
        }
        return total;
    }

    private static int multipleDigits(int number) {
        int total = 1;
        String stringNumber = Integer.toString(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            total *= Character.getNumericValue(stringNumber.charAt(i));
        }
        return total;
    }

    private static int getMaxNumber(List<Integer> member) {
        int max = 0;
        for (Integer page : member) {
            max = Math.max(sumDigits(page), multipleDigits(page));
        }
        return max;
    }


}