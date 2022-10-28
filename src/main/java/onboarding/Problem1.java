package onboarding;

import java.util.Arrays;
import java.util.List;

/**
 * 기능 목록
 * 1. 입력 값이 유효한 지 검사
 * 2. 페이지 번호의 각 자리 숫자를 연산한 결과 중 가장 큰 수 계산
 * 3. 본인의 점수(2번의 결과 값들 중 가장 큰 수) 계산
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkValidation(pobi) || !checkValidation(crong)) {
            return -1;
        }

        final int maxOfPobi = Math.max(getLargestNum(pobi.get(0)), getLargestNum(pobi.get(1)));
        final int maxOfCrong = Math.max(getLargestNum(crong.get(0)), getLargestNum(crong.get(1)));

        if (maxOfPobi == maxOfCrong) {
            return 0;
        } else {
            return (maxOfPobi > maxOfCrong) ? 1 : 2;
        }
    }

    /**
     * 리스트가 유효한 지 검사
     *
     * @param pages
     * @return true if list is validate
     */
    private static boolean checkValidation(List<Integer> pages) {
        final int leftPage = pages.get(0);
        final int rightPage = pages.get(1);

        if (leftPage + 1 != rightPage) {
            return false;
        }

        if (leftPage % 2 == 0 || rightPage % 2 != 0) {
            return false;
        }

        if (leftPage <= 1 || rightPage >= 400) {
            return false;
        }

        return true;
    }

    /**
     * 페이지 번호를 각 자리 숫자의 배열로 변환
     *
     * @param page
     * @return int[] with page numbers
     */
    private static int[] toList(Integer page) {
        return Arrays.stream(page.toString().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * 페이지 번호의 각 자리 숫자를 연산 해 가장 큰 수를 계산
     *
     * @param page
     * @return largest number of calculation
     */
    private static int getLargestNum(Integer page) {
        final int[] pageNums = toList(page);
        final int totalAdd = Arrays.stream(pageNums).sum();
        final int totalMultiply = Arrays.stream(pageNums).reduce(1, (x, y) -> x * y);

        return Math.max(totalAdd, totalMultiply);
    }

    /**
     * 본인의 점수 계산
     * @param pages
     * @return 본인의 점수
     */
    private static int getScore(List<Integer> pages) {
        final int leftPage = getLargestNum(pages.get(0));
        final int rightPage = getLargestNum(pages.get(1));
        return Math.max(leftPage, rightPage);
    }
}