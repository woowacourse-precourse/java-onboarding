package onboarding;

import java.util.List;

class Problem1 {
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTIONS = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (isWrongInput(pobi) || isWrongInput(crong)) {
            return EXCEPTIONS;
        }
        answer = getGameResult(pobi, crong);
        return answer;
    }

    public static int getAddDigitsResult(int pageNumber) {
        int addResult = 0;
        while (pageNumber != 0) {
            addResult += pageNumber % 10;
            pageNumber /= 10;
        }
        return addResult;
    }

    public static int getMultiplyDigitsResult(int pageNumber) {
        int multiplyResult = 1;
        while (pageNumber != 0) {
            multiplyResult *= pageNumber % 10;
            pageNumber /= 10;
            if (pageNumber == 0) {
                break;
            }
        }
        return multiplyResult;
    }

    public static int getLeftPageMaximum(List<Integer> pageList) {
        int maximumResult = 0;
        maximumResult = Math.max(getAddDigitsResult(pageList.get(0)), getMultiplyDigitsResult(pageList.get(0)));
        return maximumResult;
    }

    public static int getRightPageMaximum(List<Integer> pageList) {
        int maximumResult = 0;
        maximumResult = Math.max(getAddDigitsResult(pageList.get(1)), getMultiplyDigitsResult(pageList.get(1)));
        return maximumResult;
    }

    public static int getScore(List<Integer> pageList) {
        int score = 0;
        score = Math.max(getLeftPageMaximum(pageList), getRightPageMaximum(pageList));
        return score;
    }

    public static int getGameResult(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        if (pobiScore == crongScore) {
            return DRAW;
        }
        return -1;
    }

    public static boolean isWrongInput(List<Integer> user) {
        if (user.size() != 2) {
            return true;
        }
        if (user.get(0) % 2 == 0) {
            return true;
        }
        if (user.get(1) % 2 == 1) {
            return true;
        }
        if ((user.get(1) - user.get(0)) != 1) {
            return true;
        }
        if (user.get(0) == 1 || user.get(0) == 399) {
            return true;
        }
        if (user.get(0) < 1 || user.get(1) > 400) {
            return true;
        }
        return false;
    }
}