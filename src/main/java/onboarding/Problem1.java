package onboarding;

import java.util.List;

class Problem1 {

    static boolean exceptionFlag = false;

    public void checkException(List<Integer> pages){
        
    }

    public int calculateMaximumAddOrMultiply(int pageNum){
        int thirdDigit = pageNum/100;
        int secondDigit = (pageNum%100)/10;
        int firstDigit = (pageNum%10);

        int addNum = thirdDigit+secondDigit+firstDigit;
        int multiplyNum = thirdDigit*secondDigit*firstDigit;

        return Math.max(addNum, multiplyNum);
    }

    public int calculateScore(List<Integer> pages){
        int leftScore = calculateMaximumAddOrMultiply(pages.get(0));
        int rightScore = calculateMaximumAddOrMultiply(pages.get(1));

        return Math.max(leftScore, rightScore);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 T = new Problem1();

        T.checkException(pobi);
        T.checkException(crong);
        if(exceptionFlag) return -1;

        int pobiScore = T.calculateScore(pobi);
        int crongScore = T.calculateScore(crong);

        if(pobiScore>crongScore) return 1;
        if(pobiScore<crongScore) return 2;
        return 0;
    }
}