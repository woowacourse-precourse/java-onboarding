package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static boolean exceptionFlag;

    public void checkException(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);

        if(left+1!=right){
            exceptionFlag=true;
            return;
        }

        if(left%2==0 || right%2==1){
            exceptionFlag=true;
            return;
        }

        if(left<1 || left>400 || right<1 || right>400){
            exceptionFlag=true;
        }
    }

    public int[] splitDigits(int pageNum){
        int thirdDigit = pageNum/100;
        int secondDigit = (pageNum%100)/10;
        int firstDigit = (pageNum%10);

        int[] digits = {thirdDigit, secondDigit, firstDigit};

        return digits;
    }

    public int calculateMaximumAddOrMultiply(int pageNum){

        int[] digits = splitDigits(pageNum);

        int addNum = 0;
        int multiplyNum = 1;

        for(int digit : digits){
            addNum+=digit;
            if(digit==0) digit++;
            multiplyNum*=digit;
        }

        return Math.max(addNum, multiplyNum);
    }

    public int calculateScore(List<Integer> pages){
        int leftScore = calculateMaximumAddOrMultiply(pages.get(0));
        int rightScore = calculateMaximumAddOrMultiply(pages.get(1));

        return Math.max(leftScore, rightScore);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 T = new Problem1();

        exceptionFlag = false;
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