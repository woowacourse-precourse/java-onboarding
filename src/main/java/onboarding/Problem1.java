package onboarding;

import java.util.Arrays;
import java.util.List;

/**
 * 기능 목록
 * 1. 입력 값이 유효한 지 검사
 * 2. 페이지 번호의 각 자리 숫자를 연산한 결과 중 가장 큰 수 계산
 * 3. 본인의 점수(2번의 결과 값들 중 가장 큰 수) 계산
 * 4. 3번으로 결과 계산
 */

class Problem1 {
    private enum Result {
        EXCEPTION(-1), DRAW(0), POBI(1), CRONG(2);

        private final int result;

        Result(int result) {
            this.result = result;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkValidation(pobi) || !checkValidation(crong)) {
            return Result.EXCEPTION.result;
        } else {
            return getResult(getScore(pobi), getScore(crong));
        }
    }

    /**
     * 리스트가 유효한 지 검사
     *
     * @param pages
     * @return 리스트가 유효햐면 true, 아니면 false
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
     * @return 페이지 번호의 각 자리 숫자를 담은 array
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
     * @return 페이지 번호로 덧/곱셈 한 결과 중 가장 큰 수
     */
    private static int getLargestNum(Integer page) {
        final int[] pageNums = toList(page);
        final int totalAdd = Arrays.stream(pageNums).sum();
        final int totalMultiply = Arrays.stream(pageNums).reduce(1, (x, y) -> x * y);

        return Math.max(totalAdd, totalMultiply);
    }

    /**
     * 본인의 점수 계산
     *
     * @param pages
     * @return 본인의 점수
     */
    private static int getScore(List<Integer> pages) {
        final int leftPage = getLargestNum(pages.get(0));
        final int rightPage = getLargestNum(pages.get(1));
        return Math.max(leftPage, rightPage);
    }

    /**
     * 결과를 반환
     *
     * @param pobi
     * @param crong
     * @return 결과(무승부, 포비 승, 크롱 승)
     */
    private static int getResult(int pobi, int crong) {
        if (pobi == crong) {
            return Result.DRAW.result;
        } else if (pobi > crong) {
            return Result.POBI.result;
        } else {
            return Result.CRONG.result;
        }
    }
}