package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
            return answer;
        }
        int pobiMaxNumInLeftPage = getMaxNumberAtPage(pobi.get(0));
        int pobiMaxNumInRightPage = getMaxNumberAtPage(pobi.get(1));
        int crongMaxNumInLeftPage = getMaxNumberAtPage(crong.get(0));
        int crongMaxNumInRightPage = getMaxNumberAtPage(crong.get(1));

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