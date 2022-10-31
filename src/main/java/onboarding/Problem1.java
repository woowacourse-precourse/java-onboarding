package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;

        if ((exceptionCheck(pobi,crong)){
            return -1;
        }

        int pobiScore = resultScore(pobi.get(0), pobi.get(1));
        int crongScore = resultScore(crong.get(0), crong.get(1));

        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore < crongScore){
            return 2;
        }

        return -1;
    }

    public static int resultScore(int leftPage, int rightPage) {
        return Math.max(pageScore(leftPage), pageScore(rightPage));
    }

    public static int pageScore(int pageNum) {
        int tmp = pageNum;
        int plus = 0;
        int multiply = 1;

        while (tmp > 0) {
            plus += tmp % 10;
            multiply *= tmp % 10;
            tmp /= 10;
        }

        return Math.max(plus, multiply);
    }

    public static boolean exceptionCheck(List<Integer> pobi, List<Integer> crong){
        if (pobi.get(0) % 2 != 1 || pobi.get(1) != pobi.get(0) + 1) {
            return true;
        }
        if (crong.get(0) % 2 != 1 || crong.get(1) != crong.get(0) + 1) {
            return true;
        }
        if (pobi.get(0) <= 0 || pobi.get(0) > 400 || pobi.get(1) <= 0 || pobi.get(1) > 400) {
            return true;
        }
        if (crong.get(0) <= 0 || crong.get(0) > 400 || crong.get(1) <= 0 || crong.get(1) > 400) {
            return true;
        }

        return false;
    }

}