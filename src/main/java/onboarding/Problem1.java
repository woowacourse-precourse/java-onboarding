package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkException(pobi, crong)) {
            return -1;
        }
        int pobiPoint = getMyPoint(pobi);
        int crongPoint = getMyPoint(crong);
        answer = whoIsWinner(pobiPoint, crongPoint);
        return answer;
    }

    private static List<Integer> getEachDigit(Integer pageNum) {
        List<Integer> eachDigit = new ArrayList<>();
        String[] stringDigitArray = pageNum.toString().split("");
        for(String digit : stringDigitArray) {
             eachDigit.add(Integer.parseInt(digit));
        }
        return eachDigit;
    }

    private static int sumValue(List<Integer> eachDigit) {
        int sum = 0;
        for(Integer digit : eachDigit) {
            sum = sum + digit;
        }
        return sum;
    }

    private static int mulValue(List<Integer> eachDigit) {
        int mul = 1;
        for(Integer digit : eachDigit) {
            mul = mul * digit;
        }
        return mul;
    }

    private static int getMyPoint(List<Integer> gamer) {
        List<Integer> leftPageDigit = getEachDigit(gamer.get(0));
        List<Integer> rightPageDigit = getEachDigit(gamer.get(1));
        int leftMax = Math.max(sumValue(leftPageDigit), mulValue(leftPageDigit));
        int rightMax = Math.max(sumValue(rightPageDigit), mulValue(rightPageDigit));
        int point = Math.max(leftMax, rightMax);
        return point;
    }

    private static int whoIsWinner(int gamer1, int gamer2) {
        if (gamer1 > gamer2) {
            return 1;
        } else if (gamer1 < gamer2) {
            return 2;
        } else if (gamer1 == gamer2) {
            return 0;
        }

        return -1;
    }

    private static boolean checkException(List<Integer> gamer1, List<Integer> gamer2) {
        if(!isLeftOddRightEven(gamer1) || !isLeftOddRightEven(gamer2)) {
            return true;
        }

        if(notAdjacent(gamer1) || notAdjacent(gamer2)) {
            return true;
        }

        final int MAX_PAGE = 400;
        final int MIN_PAGE = 1;
        // 시작 면이나 마지막 면이 나오는지 검증
        if(gamer1.get(0) == MIN_PAGE || gamer1.get(1) == MAX_PAGE
                || gamer2.get(0) == MIN_PAGE || gamer2.get(1) == MAX_PAGE) {
            return true;
        }

        // 페이지 번호가 정해진 범위에 속하는지 검증
        for(Integer page : gamer1) {
            if(page < MIN_PAGE || page > MAX_PAGE) {
                return true;
            }
        }
        for(Integer page : gamer2) {
            if(page < MIN_PAGE || page > MAX_PAGE) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLeftOddRightEven(List<Integer> gamer) {
        if(gamer.get(0) % 2 == 0 || gamer.get(1) % 2 == 1) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean notAdjacent(List<Integer> gamer) {
        int leftPage = gamer.get(0);
        int rightPage = gamer.get(1);
        if(rightPage - leftPage != 1) {
            return true;
        } else {
            return false;
        }
    }
}
