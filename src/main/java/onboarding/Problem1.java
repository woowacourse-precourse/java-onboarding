package onboarding;

import java.util.List;

/**
 * goal: 포비와 크롱 중 주어진 조건에 맞는 값을 구했을 때 누가 더 큰 값을 가졌는지 구하기
 */

/**
 * 문제 풀이 순서
 * 1. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 *    -> Math.max(왼쪽 페이지 각 자리수 더하기, 왼쪽 페이지 각 자리수 곱하기)
 * 2. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 *    -> Math.max(오른쪽 페이지 각 자리수 더하기, 오른쪽페이지 각 자리수 곱하기)
 * 3. Math.max(1번 값, 2번 값)이 나의 점수
 * 4. 포비와 크롱 중 3번의 값이 더 큰 사람이 승자
 */

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 페이지 검사
        if (!validatePage(pobi) || !validatePage(crong)) {
            return -1;
        }

        int pobiScore = findBiggerScore(pobi);
        int crongScore = findBiggerScore(crong);

        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        return 2;
    }

    private static boolean validatePage(List<Integer> pages) {
        // 왼쪽페이지(idx = 0)는 홀수, 오른쪽 페이지(idx = 1)는 짝수여야 함.
        if (pages.get(0) % 2 == 0 || pages.get(1) % 2 != 0) {
            return false;
        }
        // 오른쪽 페이지가 왼쪽 페이지보다 1 커야 함.
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        // 페이지는 1부터 400까지의 숫자여야 함.
        if (pages.get(0) < 1 || pages.get(0) > 400 || pages.get(1) < 1 || pages.get(1) > 400) {
            return false;
        }
        return true;
    }

    private static int findBiggerScore(List<Integer> lst) {
        int sumLeftPage = sumEachDigit(lst.get(0).toString());
        int sumRightPage = sumEachDigit(lst.get(1).toString());
        int biggerSum = Math.max(sumLeftPage, sumRightPage);

        int multiplyLeftPage = multiplyEachDigit(lst.get(0).toString());
        int multiplyRightPage = multiplyEachDigit(lst.get(1).toString());
        int biggerMultiply = Math.max(multiplyLeftPage, multiplyRightPage);
        return Math.max(biggerSum, biggerMultiply);
    }

    private static int sumEachDigit(String numberStr) {
        int result = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            result += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return result;
    }

    private static int multiplyEachDigit(String numberStr) {
        int result = 1;
        for (int i = 0; i < numberStr.length(); i++) {
            result *= Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return result;
    }
}
