package onboarding;

import java.util.Arrays;
import java.util.List;

/**
 * 기능 목록
 *  a. 각 페이지 유효성 검사 기능 - validatePage()
 *      a-1. 각 페이지가 1씩 순차적인지 검사하는 기능 - isSequentialPage()
 *      a-2. 각 페이지가 첫 페이지 또는 마지막 페이지인지 검사하는 기능 - isFirstOrLastPage()
 *  b. 페이지의 각 자리수를 더한 값과 곱한 값중 가장 큰 값을 계산하는 기능 - max()
 *      b-1. Integer 숫자 각 자리수를 int[]로 변환하는 기능 - toIntArray()
 *      b-2. int[] 배열의 합을 구하는 기능 - getSumNumber()
 *      b-3. int[] 배열의 곱을 구하는 기능 - getMulNumber()
 * */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePage(pobi) || !validatePage(crong)) {
            return -1;
        }

        int pobiMaxNum = max(pobi);
        int crongMaxNum = max(crong);

        if (pobiMaxNum == crongMaxNum) {
            return 0;
        }
        return pobiMaxNum > crongMaxNum ? 1 : 2;
    }

    private static boolean validatePage(List<Integer> pages) {
        final int FIRST_PAGE = 0;
        final int SECOND_PAGE = 1;

        boolean result = isSequentialPage(pages.get(FIRST_PAGE), pages.get(SECOND_PAGE));
        if (isFirstOrLastPage(pages.get(FIRST_PAGE), pages.get(SECOND_PAGE))) {
            result = false;
        }
        return result;
    }

    private static boolean isSequentialPage(int first, int last) {
        return (last - 1) == first;
    }

    private static boolean isFirstOrLastPage(int first, int second) {
        final int FIRST_PAGE_NUM = 1;
        final int LAST_PAGE_NUM = 400;

        return first == FIRST_PAGE_NUM || second == LAST_PAGE_NUM;
    }

    private static int max(List<Integer> pages) {
        final int FIRST_PAGE = 0;
        final int SECOND_PAGE = 1;

        int[] eachNumberInFirstPage = toIntArray(pages.get(FIRST_PAGE));
        int[] eachNumberInSecondPage = toIntArray(pages.get(SECOND_PAGE));

        int firstNum = Math.max(getSumNumber(eachNumberInFirstPage), getMulNumber(eachNumberInFirstPage));
        int secondNum = Math.max(getSumNumber(eachNumberInSecondPage), getMulNumber(eachNumberInSecondPage));

        return Math.max(firstNum, secondNum);
    }

    private static int[] toIntArray(Integer page) {
        return Arrays.stream(String.valueOf(page).split(""))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static int getSumNumber(int[] eachNumberInPage) {
        return Arrays.stream(eachNumberInPage)
                .max()
                .orElse(0);
    }

    private static int getMulNumber(int[] eachNumberInPage) {
        return Arrays.stream(eachNumberInPage)
                .reduce(1, (f, s) -> f * s);
    }
}