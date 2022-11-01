package onboarding;

import java.util.List;


class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;

    private static final int MIN = 1;
    private static final int MAX = 400;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!canPage(pobi) || !canPage(crong)) return EXCEPTION;
        return getFinalResult(getUserScore(pobi), getUserScore(crong));

    }
    public static int getFinalResult(int pobiScore, int crongScore) {

        return (pobiScore > crongScore) ? POBI_WIN : (pobiScore == crongScore) ? DRAW : CRONG_WIN;

    }
    public static int getUserScore(List<Integer> user) {
        int firstPage = getBiggerScore(user.get(LEFT));
        int secondPage = getBiggerScore(user.get(RIGHT));
        return firstPage > secondPage ? firstPage : secondPage;
    }
    public static int getBiggerScore(int page) {
        return getSumPage(page) > getMultiplyPage(page) ? getSumPage(page) : getMultiplyPage(page);
    }
    public static int getSumPage(int page) {
        int sumResult = 0;
        String pages = Integer.toString(page);
        for (int i = 0; i < pages.length(); i++) {
            sumResult += (pages.charAt(i) - '0');
        }
        return sumResult;
    }

    public static int getMultiplyPage(int page) {
        int multiplyResult = 1;
        String pages = Integer.toString(page);
        for (int i = 0; i < pages.length(); i++) {
            multiplyResult *= (pages.charAt(i) - '0');
        }
        return multiplyResult;
    }

    public static boolean canPage(List<Integer> user) {
        if (user.get(LEFT) >= MIN && user.get(LEFT) <= MAX && user.get(RIGHT) >= MIN && user.get(RIGHT) <= MAX && (user.get(RIGHT) - user.get(LEFT)) == 1
                && user.get(LEFT) % 2 == 1 && user.get(RIGHT) % 2 == 0)
            return true;
        return false;
    }

}