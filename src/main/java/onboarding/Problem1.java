package onboarding;

import java.util.List;

class Problem1 {


    public static final int LIST_SIZE = 2;
    public static final int PAGE_MIN = 1;
    public static final int PAGE_MAX = 400;
    public static final int PAGE_LEFT_INDEX = 0;
    public static final int PAGE_RIGHT_INDEX = 1;
    public static final int RESULT_EXCEPTION = -1;
    public static final int RESULT_DRAW = 0;
    public static final int RESULT_POBY_WIN = 1;
    public static final int RESULT_CRONG_WIN = 2;
    public static final int PAGE_DIFF = 1;

    /**
     * @param pageList : page List(Integer)
     * @return boolean : 주어진 페이지 리스트가 valid 한가?
     */
    public static boolean validCheck(List<Integer> pageList) {
        // pobi와 crong의 길이는 2이다. 모든 페이지에는 번호가 적혀 있다.
        if (pageList == null || pageList.size() != LIST_SIZE) {
            return false;
        }
        // 페이지 번호는 1부터 400 사이이다.
        for (Integer page : pageList) {
            if (page == null || !(page >= PAGE_MIN && page <= PAGE_MAX)) {
                return false;
            }
        }
        int leftPage = pageList.get(PAGE_LEFT_INDEX);
        int rightPage = pageList.get(PAGE_RIGHT_INDEX);
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수이다.
        if (leftPage % 2 != 1 || rightPage % 2 != 0 ||
                leftPage >= rightPage || rightPage - leftPage != PAGE_DIFF) {
            return false;
        }
        return true;
    }

    /**
     * @param number : 1과 400 사이의 자연수
     * @return int : 자연수 각 자릿수들의 합
     */
    public static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /**
     * @param number : 1과 400 사이의 자연수
     * @return int : 자연수 각 자릿수들의 곱
     */
    public static int getDigitProduct(int number) {
        int product = 1;
        while (number > 0) {
            product *= number % 10;
            number /= 10;
        }
        return product;
    }

    /**
     * @param a : 자연수
     * @param b : 자연수
     * @return int : a와 b중 더 큰 수
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    private static int getMaxNumberFromPageList(List<Integer> pageList) {
        int leftPage = pageList.get(PAGE_LEFT_INDEX);
        int rightPage = pageList.get(PAGE_RIGHT_INDEX);
        int leftPageMax = max(getDigitSum(leftPage), getDigitProduct(leftPage));
        int rightPageMax = max(getDigitSum(rightPage), getDigitProduct(rightPage));
        int maxNumberFromPage = max(leftPageMax, rightPageMax);
        return maxNumberFromPage;
    }

    /**
     * @param poby  : poby의 가장 큰 수
     * @param crong : crong의 가장 큰 수
     * @return : 승자에 따른 결과 반환
     */
    public static int judgeWinner(int poby, int crong) {
        if (poby > crong) {
            return RESULT_POBY_WIN;
        } else if (poby < crong) {
            return RESULT_CRONG_WIN;
        } else if (poby == crong) {
            return RESULT_DRAW;
        }
        return RESULT_EXCEPTION;
    }

    public static int solution(List<Integer> pobiPageList, List<Integer> crongPageList) {
        // exception
        if (!validCheck(pobiPageList) || !validCheck(crongPageList)) {
            return RESULT_EXCEPTION;
        }
        // game logic
        int pobiMaxNumber = getMaxNumberFromPageList(pobiPageList);
        int crongMaxNumber = getMaxNumberFromPageList(crongPageList);
        // judge logic
        return judgeWinner(pobiMaxNumber, crongMaxNumber);
    }
}