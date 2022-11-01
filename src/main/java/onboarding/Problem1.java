package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    static final int FIRST_PAGE = 1;
    static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 입력 페이지 검증 후 예외 사항일 경우 -1을 리턴한다.
        if (isNotPageValid(pobi) || isNotPageValid(crong)) {
            return -1;
        }

        // 포비의 왼쪽, 오른쪽 페이지 번호를 구한다.
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        // 크롱의 왼쪽, 오른쪽 페이지 번호를 구한다.
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 포비의 결과 리스트를 구한다.
        List<Integer> pobiResultList = List.of(getSumValue(pobiLeftPage), getSumValue(pobiRightPage),
                getMultiplyValue(pobiLeftPage), getMultiplyValue(pobiRightPage));

        int pobiScore = getMaxValue(pobiResultList);

        // 크롱의 결과 리스트를 구한다.
        List<Integer> crongResultList = List.of(getSumValue(crongLeftPage), getSumValue(crongRightPage),
                getMultiplyValue(crongLeftPage), getMultiplyValue(crongRightPage));

        int crongScore = getMaxValue(crongResultList);

        return compareResult(pobiScore, crongScore);
    }

    /**
     * 입력 페이지에 대한 검증을 진행한다.
     *
     * @param pageNums 사용자의 페이지 번호 리스트
     * @return 올바르지 않은 페이지 리스트라면 true, 아니라면 false
     */
    private static boolean isNotPageValid(List<Integer> pageNums) {
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        /* 입력 페이지에 대해서 검증을 진행한다. 다음은 예외 사항으로 간주한다.
            1. 페이지의 범위가 1~400 사이가 아닌 경우
            2. 페이지가 시작이나 마지막 면인 경우
            3. 왼쪽 페이지가 홀수가 아니고, 오른쪽 페이지가 짝수가 아닌 경우
            4. 왼쪽, 오른쪽 페이지의 차가 1이 아닌 경우 (연속된 페이지가 아님)
         */
        return isNotPageRange(leftPage, rightPage) || isPageFirstOrLast(leftPage) ||
                isNotPageOddAndEven(leftPage, rightPage) || isNotPageContinuous(leftPage, rightPage);
    }

    /**
     * 입력 페이지의 범위가 1~400 사이가 아닌지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 1~400 사이가 아니라면 true, 맞다면 false
     */
    private static boolean isNotPageRange(int leftPage, int rightPage) {
        return leftPage < FIRST_PAGE || leftPage >= LAST_PAGE || rightPage <= FIRST_PAGE || rightPage > LAST_PAGE;
    }

    /**
     * 왼쪽 페이지 번호가 시작 면이거나 마지막 면인지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @return 왼쪽 페이지의 값이 1이거나 399라면 true, 아니라면 false
     */
    private static boolean isPageFirstOrLast(int leftPage) {
        return leftPage == FIRST_PAGE || leftPage == LAST_PAGE-1;
    }

    /**
     * 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아닌지 판단한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 왼쪽 페이지가 홀수가 아니고 오른쪽 페이지가 짝수가 아니면 true, 아니라면 false
     */
    private static boolean isNotPageOddAndEven(int leftPage, int rightPage) {
        return leftPage % 2 != 1 && rightPage % 2 != 0;
    }

    /**
     * 왼쪽, 오른쪽 페이지가 연속적이지 않은지 확인한다.
     *
     * @param leftPage 왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 오른쪽, 왼쪽 페이지의 차가 1이 아니라면 true, 아니라면 false
     */
    private static boolean isNotPageContinuous(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }

    /**
     * 입력 받은 페이지 번호의 각 자리수의 합을 구한다.
     *
     * @param page 페이지 번호
     * @return 각 자리수의 합
     */
    private static int getSumValue(int page) {
        int[] pageArr = getPageValueArray(page);

        return Arrays.stream(pageArr).sum();
    }

    /**
     * 입력 받은 페이지 번호의 각 자리수의 곱을 구한다.
     *
     * @param page 페이지 번호
     * @return 각 자리수의 곱
     */
    private static int getMultiplyValue(int page) {
        int[] pageArr = getPageValueArray(page);

        int multiVal = 1;
        for(int pageVal : pageArr) {
            multiVal *= pageVal;
        }

        return multiVal;
    }

    /**
     * 입력 받은 페이지의 각 자릿수를 담은 배열을 구한다.
     *
     * @param page 페이지 번호
     * @return 각 자릿수가 담긴 배열
     */
    private static int[] getPageValueArray(int page) {
        String[] digitStrArr = String.valueOf(page).split("");

        return Stream.of(digitStrArr).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * 페이지 번호에 따른 자리수 계산 결과 중 가장 큰 값을 리턴한다.
     *
     * @param resultArr 자리수 계산 결과를 담은 리스트
     * @return 가장 큰 값
     */
    private static int getMaxValue(List<Integer> resultArr) {
        int maxVal = 0;
        for(int resultVal : resultArr) {
            maxVal = Math.max(maxVal, resultVal);
        }

        return maxVal;
    }

    /**
     * 두 사람의 점수를 비교하여 결과를 출력한다.
     *
     * @param pobiScore 포비의 점수
     * @param crongScore 크롱의 점수
     * @return 포비가 이기면 1, 크롱이 이기면 2, 무승부는 0을 리턴한다.
     */
    private static int compareResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }
}