package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        int pobiMaxNum;
        int crongMaxNum;

        if(pobi.size()!=2 || crong.size()!=2){
            return -1;
        }
        if (pobi.get(0)%2==0 || crong.get(0)%2==0){
            return -1;
        }
        if(pobi.get(0)<1 || pobi.get(1)>400 || (pobi.get(0)+1 != pobi.get(1))){
            return -1;
        }
        if(crong.get(0)<1 || crong.get(1)>400 || (crong.get(0)+1 != crong.get(1))){
            return -1;
        }

        pobiMaxNum = getMaxNum(pobi.get(0),pobi.get(1));
        crongMaxNum = getMaxNum(crong.get(0),crong.get(1));

        if (pobiMaxNum == crongMaxNum) {
            answer = 0;
            return answer;
        }

        answer = Math.max(pobiMaxNum,crongMaxNum);
        if(answer==pobiMaxNum)
            answer = 1;
        else
            answer = 2;
        
        return answer;
    }

    public static int getMaxNum(int leftNum,int rightNum){
        int rightDigit1 = rightNum/100;
        int rightDigit2 = (rightNum%100)/10;
        int rightDigit3 = (rightNum%10);

        int leftDigit1 = leftNum/100;
        int leftDigit2 = (leftNum%100)/10;
        int leftDigit3 = (leftNum%10);

        int rightSum = rightDigit1+rightDigit2+rightDigit3;
        int leftSum = leftDigit1+leftDigit2+leftDigit3;

        if(rightDigit1 == 0)
            rightDigit1 = 1;
        if(rightDigit2 == 0)
            rightDigit2 = 1;
        if(leftDigit1 == 0)
            leftDigit1 = 1;
        if(leftDigit2 == 0)
            leftDigit2 = 1;

        int rightMul = rightDigit1*rightDigit2*rightDigit3;
        int leftMul = leftDigit1*leftDigit2*leftDigit3;

        int mulResult = Math.max(rightMul,leftMul);
        int sumResult = Math.max(rightSum,leftSum);

        return Math.max(mulResult,sumResult);
    }
}