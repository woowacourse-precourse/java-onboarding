package onboarding;

import java.util.List;

class Problem1 {
    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isNotValidPage(pobi) || isNotValidPage(crong)) {
            return EXCEPTION;
        }
        int pobiMaxNumber = getBiggestNum(pobi);
        int crongMaxNumber = getBiggestNum(crong);

        return getWinner(pobiMaxNumber, crongMaxNumber);
    }
    private static boolean isNotValidPage(List<Integer> pages) {
        if (!isValidSize(pages) || !isValidRange(pages)) {
            return true;
        }

        if (!isValidOddEven(pages) || !isValidInterval(pages)) {
            return true;
        }
        return false;
    }

    private static boolean isValidRange(List<Integer> pages) {
        boolean checker = true;

        for (int page : pages) {
            checker = checker && isContained(page);
        }
        if (checker) {
            return true;
        }
        return false;
    }
    private static boolean isValidSize(List<Integer> pages) {
        return pages.size() == 2;
    }
    private static boolean isContained(int page) {
        return FIRST_PAGE < page && page < LAST_PAGE;
    }

    private static boolean isValidOddEven(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return false;
        }
        return true;
    }

    private static boolean isValidInterval(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return rightPage - leftPage == 1;
    }

    private static int getBiggestNum(List<Integer> pages) {
        int BiggestNum = 0;

        for (int page : pages) {
            BiggestNum = Math.max(BiggestNum, getBiggerNum(page));
        }
        return BiggestNum;
    }

    private static int getBiggerNum(int page) {
        int biggerNum = Math.max(sumNum(page), mulNum(page));

        return biggerNum;
    }

    private static int sumNum(int page) {
        int resNum = 0;
        String pageNum = Integer.toString(page);

        for (int i = 0; i < pageNum.length(); i++) {
            resNum += pageNum.charAt(i) - '0';
        }
        return resNum;
    }

    private static int mulNum(int page) {
        int resNum = 1;
        String pageNum = Integer.toString(page);

        for (int i = 0; i < pageNum.length(); i++) {
            resNum *= pageNum.charAt(i) - '0';
        }
        return resNum;
    }

    private static int getWinner(int pobiNum, int crongNum) {
        if (pobiNum > crongNum) {
            return (POBI_WIN);
        } else if (pobiNum < crongNum) {
            return (CRONG_WIN);
        }
        return (DRAW);
    }
}