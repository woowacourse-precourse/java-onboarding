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

        // 첫 페이지 혹은 끝 페이지 포함하는지 확인
        if (isHavingFirstPage(pobi) || isHavingLastPage(pobi)
                || isHavingFirstPage(crong) || isHavingLastPage(crong)) {
            return Constant.EXCEPTION;
        }

        // 좌측 페이지가 홀수이고 우측 페이지가 짝수인지 확인
        if (isEvenPage(pobi.get(Constant.LEFT_PAGE)) || isOddPage(pobi.get(Constant.RIGHT_PAGE))
                || isEvenPage(crong.get(Constant.LEFT_PAGE)) || isOddPage(crong.get(Constant.RIGHT_PAGE))) {
            return Constant.EXCEPTION;
        }

        // 좌측과 우측 페이지의 차가 1인지 확인 및 우측 페이지가 더 큰지 확인
        if (pobi.get(Constant.RIGHT_PAGE) - pobi.get(Constant.LEFT_PAGE) != 1
                || crong.get(Constant.RIGHT_PAGE) - crong.get(Constant.LEFT_PAGE) != 1) {
            return Constant.EXCEPTION;
        }

        int maxLeftPointOfPobi = getMaxLeftPoint(pobi);
        int maxRightPointOfPobi = getMaxRightPoint(pobi);
        int maxPointOfPobi = Math.max(maxLeftPointOfPobi, maxRightPointOfPobi);

        int maxLeftPointOfCrong = getMaxLeftPoint(crong);
        int maxRightPointOfCrong = getMaxRightPoint(crong);
        int maxPointOfCrong = Math.max(maxLeftPointOfCrong, maxRightPointOfCrong);

        if (maxPointOfPobi > maxPointOfCrong) {
            return Constant.WIN_POBI;
        }
        if (maxPointOfPobi < maxPointOfCrong) {
            return Constant.WIN_CRONG;
        }
        return Constant.DRAW;

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