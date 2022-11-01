package onboarding;

import java.util.List;

class Problem1 {
    interface Constant {
        int FIRST_PAGE = 1;
        int LAST_PAGE = 400;
        int LEFT_PAGE = 0;
        int RIGHT_PAGE = 1;
        int EXCEPTION = -1;
        int WIN_POBI = 1;
        int WIN_CRONG = 2;
        int DRAW = 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkException(pobi, crong) != null) {
            return Constant.EXCEPTION;
        }
        int maxPointOfPobi = getMaxPoint(pobi);
        int maxPointOfCrong = getMaxPoint(crong);

        return getWinner(maxPointOfPobi, maxPointOfCrong);

    }

    private static Integer checkException(List<Integer> pobi, List<Integer> crong) {
        if (isHavingFirstPage(pobi) || isHavingLastPage(pobi)
                || isHavingFirstPage(crong) || isHavingLastPage(crong)) {
            return Constant.EXCEPTION;
        }
        if (isEvenPage(pobi.get(Constant.LEFT_PAGE)) || isOddPage(pobi.get(Constant.RIGHT_PAGE))
                || isEvenPage(crong.get(Constant.LEFT_PAGE)) || isOddPage(crong.get(Constant.RIGHT_PAGE))) {
            return Constant.EXCEPTION;
        }
        if (pobi.get(Constant.RIGHT_PAGE) - pobi.get(Constant.LEFT_PAGE) != 1
                || crong.get(Constant.RIGHT_PAGE) - crong.get(Constant.LEFT_PAGE) != 1) {
            return Constant.EXCEPTION;
        }
        return null;
    }

    private static int getWinner(int maxPointOfPobi, int maxPointOfCrong) {
        if (maxPointOfPobi > maxPointOfCrong) {
            return Constant.WIN_POBI;
        }
        if (maxPointOfPobi < maxPointOfCrong) {
            return Constant.WIN_CRONG;
        }
        return Constant.DRAW;
    }

    private static int getMaxPoint(List<Integer> crew) {
        int maxLeftPoint = getMaxLeftPoint(crew);
        int maxRightPoint = getMaxRightPoint(crew);
        return Math.max(maxLeftPoint, maxRightPoint);
    }

    private static int getMaxRightPoint(List<Integer> openPages) {
        return Math.max(getSumOfEachDigits(openPages.get(Constant.RIGHT_PAGE)), getMulOfEachDigits(openPages.get(Constant.RIGHT_PAGE)));
    }

    private static int getMaxLeftPoint(List<Integer> openPages) {
        return Math.max(getSumOfEachDigits(openPages.get(Constant.LEFT_PAGE)), getMulOfEachDigits(openPages.get(Constant.LEFT_PAGE)));
    }

    private static int getMulOfEachDigits(int page) {
        char[] digitsArray = getDigitsArray(page);
        int sum = 1;
        for (char c : digitsArray) {
            sum *= c - '0';
        }
        return sum;
    }

    private static int getSumOfEachDigits(int page) {
        char[] digitsArray = getDigitsArray(page);
        int sum = 0;
        for (char c : digitsArray) {
            sum += c - '0';
        }
        return sum;
    }

    private static char[] getDigitsArray(int page) {
        return String.valueOf(page).toCharArray();

    }

    public static boolean isHavingFirstPage(List<Integer> openPages) {
        return openPages.contains(Constant.FIRST_PAGE);
    }

    public static boolean isHavingLastPage(List<Integer> openPages) {
        return openPages.contains(Constant.LAST_PAGE);
    }

    public static boolean isOddPage(int page) {
        return page % 2 == 1;
    }

    public static boolean isEvenPage(int page) {
        return page % 2 == 0;
    }
}