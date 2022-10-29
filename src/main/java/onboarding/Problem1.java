package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    private static final int PAGE_START = 1;
    private static final int PAGE_END = 400;

    /**
     * 숫자의 각 자릿수를 나누는 함수
     * ex) 123 -> [3, 2, 1]
     */
    private static int[] splitDigit(int num) {
        int rest = num / 10;
        int place1 = num % 10;
        int place2 = rest % 10;
        int place3 = rest / 10;

        return new int[]{place1, place2, place3};
    }

    /**
     * (요구사항 2번 및 요구사항 3번)
     * 페이지의 각 자릿수를 더하는 함수
     */
    private static int getPageDigitSum(int[] splitedPage) {
        return splitedPage[0] + splitedPage[1] + splitedPage[2];
    }

    /**
     * (요구사항 2번 및 요구사항 3번)
     * 페이지의 각 자릿수를 곱하는 함수
     */
    private static int getPageDigitMul(int[] splitedPage) {
        if(splitedPage[2] == 0 && splitedPage[1] == 0) {
            return splitedPage[0]; // 한자릿수의 페이지
        } else if(splitedPage[2] == 0) {
            return splitedPage[0] * splitedPage[1]; // 두자릿수의 페이지
        } else {
            return splitedPage[0] * splitedPage[1] * splitedPage[2]; // 세자릿수의 페이지
        }
    }

    /**
     * (요구사항 4번)
     * 플레이어의 점수를 계산하는 함수
     */
    private static int getScore(List<Integer> pageList) {
        int[] splitedLeftPage = splitDigit(pageList.get(0));
        int[] splitedRightPage = splitDigit(pageList.get(1));

        int leftScore = Math.max(getPageDigitSum(splitedLeftPage), getPageDigitMul(splitedLeftPage));
        int rightScore = Math.max(getPageDigitSum(splitedRightPage), getPageDigitMul(splitedRightPage));

        return Math.max(leftScore, rightScore);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    /**
     * (요구사항 6번)
     * 입력받은 페이지가 유효한지 확인하는 함수
     */
    private static boolean checkPagesValidation(List<Integer> pageList) {
        Integer leftPage = pageList.get(0);
        Integer rightPage = pageList.get(1);

        if(leftPage == null || rightPage == null) return false;

        boolean pageRange = leftPage >= PAGE_START && rightPage <= PAGE_END;
        boolean pageValidation = isOdd(leftPage) &&  isEven(rightPage);
        boolean pageContinues = leftPage + 1 == rightPage;

        return  pageRange && pageValidation && pageContinues;
    }

    /**
     *  (요구사항 5번)
     *  점수를 비교해 승자를 구분하고 게임 결과를 반환하는 함수
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!(checkPagesValidation(pobi) && checkPagesValidation(crong))) {
            return EXCEPTION;  // 예외 사항
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if(pobiScore > crongScore) {
            return POBI_WIN;   // 포비 우승
        } else if(pobiScore < crongScore) {
            return CRONG_WIN;   // 크롱 우승
        } else {
            return DRAW;   // 무승부
        }
    }
}