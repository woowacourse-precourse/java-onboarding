package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int MAX_PAGE = 400;
    private static final int MIN_PAGE = 1;
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private static final int EXCEPTION_NUM = -1;
    private static final int POBI_WIN_NUM = 1;
    private static final int CRONG_WIN_NUM = 2;
    private static final int TIE_NUM = 0;



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (checkException(pobi, crong)) {
            return EXCEPTION_NUM;
        }
        int pobiPoint = getMyPoint(pobi);
        int crongPoint = getMyPoint(crong);
        answer = whoIsWinner(pobiPoint, crongPoint);
        return answer;
    }

    private static List<Integer> getEachDigit(Integer pageNum) {
        List<Integer> eachDigit = new ArrayList<>();
        String[] stringDigitArray = pageNum.toString().split("");
        for (String digit : stringDigitArray) {
            eachDigit.add(Integer.parseInt(digit));
        }
        return eachDigit;
    }

    private static int sumValue(List<Integer> eachDigit) {
        int sum = 0;
        for (Integer digit : eachDigit) {
            sum = sum + digit;
        }
        return sum;
    }

    private static int mulValue(List<Integer> eachDigit) {
        int mul = 1;
        for (Integer digit : eachDigit) {
            mul = mul * digit;
        }
        return mul;
    }

    private static int getMyPoint(List<Integer> gamer) {
        List<Integer> leftPageDigit = getEachDigit(gamer.get(LEFT_PAGE));
        List<Integer> rightPageDigit = getEachDigit(gamer.get(RIGHT_PAGE));
        int leftMax = Math.max(sumValue(leftPageDigit), mulValue(leftPageDigit));
        int rightMax = Math.max(sumValue(rightPageDigit), mulValue(rightPageDigit));
        int point = Math.max(leftMax, rightMax);
        return point;
    }

    private static int whoIsWinner(int gamer1, int gamer2) {
        if (gamer1 > gamer2) {
            return POBI_WIN_NUM;
        } else if (gamer1 < gamer2) {
            return CRONG_WIN_NUM;
        } else if (gamer1 == gamer2) {
            return TIE_NUM;
        }

        return -1;
    }

    private static boolean checkException(List<Integer> gamer1, List<Integer> gamer2) {
        if (notLeftOddRightEven(gamer1) || notLeftOddRightEven(gamer2)) {
            return true;
        }

        if (notAdjacent(gamer1) || notAdjacent(gamer2)) {
            return true;
        }

        if (isStartOrLast(gamer1) || isStartOrLast(gamer2)) {
            return true;
        }

        if (notInRange(gamer1) || notInRange(gamer2)) {
            return true;
        }
        return false;
    }

    private static boolean notLeftOddRightEven(List<Integer> gamer) {
        int leftPage = gamer.get(0);
        int rightPage = gamer.get(1);
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean notAdjacent(List<Integer> gamer) {
        int leftPage = gamer.get(0);
        int rightPage = gamer.get(1);
        if (rightPage - leftPage != 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isStartOrLast(List<Integer> gamer) {
        int leftPage = gamer.get(0);
        int rightPage = gamer.get(1);
        if (leftPage == MIN_PAGE || rightPage == MAX_PAGE) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean notInRange(List<Integer> gamer) {
        for (Integer page : gamer) {
            if (page < MIN_PAGE || page > MAX_PAGE) {
                return true;
            }
        }
        return false;
    }
}
