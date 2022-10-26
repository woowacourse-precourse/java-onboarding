package onboarding;

import java.util.List;

class Problem1 {
    static final int FIRST_PAGE = 1;
    static final int LAST_PAGE = 400;
    static final int LEFT_PAGE = 0;
    static final int RIGHT_PAGE = 1;

    static final int EXCEPTION = -1;
    static final int WIN_POBI = 1;
    static final int WIN_CRONG = 2;
    static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 첫 페이지 혹은 끝 페이지 포함하는지 확인
        if (isHavingFirstPage(pobi) || isHavingLastPage(pobi)
                || isHavingFirstPage(crong) || isHavingLastPage(crong)) {
            return EXCEPTION;
        }

        // 좌측 페이지가 홀수이고 우측 페이지가 짝수인지 확인
        if (isEvenPage(pobi.get(LEFT_PAGE)) || isOddPage(pobi.get(RIGHT_PAGE))
                || isEvenPage(crong.get(LEFT_PAGE)) || isOddPage(crong.get(RIGHT_PAGE))) {
            return EXCEPTION;
        }

        // 좌측과 우측 페이지의 차가 1인지 확인 및 우측 페이지가 더 큰지 확인
        if (pobi.get(LAST_PAGE) - pobi.get(FIRST_PAGE) != 1
                || crong.get(LAST_PAGE) - crong.get(FIRST_PAGE) != 1) {
            return EXCEPTION;
        }

        int maxLeftPointOfPobi = Math.max(getSumOfEachDigits(pobi.get(LEFT_PAGE)), getMulOfEachDigits(pobi.get(LEFT_PAGE)));
        int maxRightPointOfPobi = Math.max(getSumOfEachDigits(pobi.get(LAST_PAGE)), getMulOfEachDigits(pobi.get(LAST_PAGE)));
        int maxPointOfPobi = Math.max(maxLeftPointOfPobi, maxRightPointOfPobi);

        int maxLeftPointOfCrong = Math.max(getSumOfEachDigits(crong.get(LEFT_PAGE)), getMulOfEachDigits(crong.get(LEFT_PAGE)));
        int maxRightPointOfCrong = Math.max(getSumOfEachDigits(crong.get(LAST_PAGE)), getMulOfEachDigits(crong.get(LAST_PAGE)));
        int maxPointOfCrong = Math.max(maxLeftPointOfCrong, maxRightPointOfCrong);

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
        return openPages.contains(FIRST_PAGE);
    }

    public static boolean isHavingLastPage(List<Integer> openPages) {
        return openPages.contains(LAST_PAGE);
    }

    public static boolean isOddPage(int page) {
        return page % 2 == 1;
    }

    public static boolean isEvenPage(int page) {
        return page % 2 == 0;
    }
}