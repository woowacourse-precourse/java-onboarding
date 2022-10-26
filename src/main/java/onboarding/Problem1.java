package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPageNumber = pobi.get(0);
        int pobiRightPageNumber = pobi.get(1);
        int crongLeftPageNumber = crong.get(0);
        int crongRightPageNumber = crong.get(1);
        if(isInvalidPage(pobiLeftPageNumber, pobiRightPageNumber, crongLeftPageNumber, crongRightPageNumber)) {
            answer = -1;
            return answer;
        }
        int pobiMaxNumInLeftPage = getMaxNumberAtPage(pobiLeftPageNumber);
        int pobiMaxNumInRightPage = getMaxNumberAtPage(pobiRightPageNumber);
        int crongMaxNumInLeftPage = getMaxNumberAtPage(crongLeftPageNumber);
        int crongMaxNumInRightPage = getMaxNumberAtPage(crongRightPageNumber);

        int pobiMaxNum = getMaxNumber(pobiMaxNumInLeftPage, pobiMaxNumInRightPage);
        int crongMaxNum = getMaxNumber(crongMaxNumInLeftPage, crongMaxNumInRightPage);

        if(pobiMaxNum > crongMaxNum) {
            answer = 1;
        } else if(pobiMaxNum == crongMaxNum){
            answer = 0;
        } else {
            answer = 2;
        }
        return answer;
    }

    public static int getMaxNumber(int x, int y){
        return x > y ? x : y;
    }

    public static boolean isInvalidPage(int pobiLeftPageNumber, int pobiRightPageNumber, int crongLeftPageNumber, int crongRightPageNumber){
        if(pobiRightPageNumber - pobiLeftPageNumber != 1
                || crongRightPageNumber - crongLeftPageNumber != 1
                || pobiRightPageNumber % 2 != 0
                || pobiLeftPageNumber % 2 != 1
                || crongRightPageNumber % 2 != 0
                || crongLeftPageNumber % 2 != 1){
            return true;
        } else return false;
    }

    public static int isOddNumber(int num){
        return num % 2;
    }
    public static int getMaxNumberAtPage(int page){
        int tmp = page;
        int totalSum = 0;
        int totalMulti = 1;
        while(tmp > 0){
            totalSum += tmp % 10;
            totalMulti *= tmp % 10;
            tmp /= 10;
        }

        return getMaxNumber(totalSum, totalMulti);
    }
}