package onboarding;

import onboarding.problem1.Calculator;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pSum, pMul, cSum, cMul;
        int pScore, cScore;
        Calculator calculator = new Calculator();
        int pobiLeft = pobi.get(0); //97
        int pobiRight = pobi.get(1); //98
        int crongLeft = crong.get(0); //197
        int crongRight = crong.get(1); //198


        //예외처리
        if((pobiLeft % 2 == 0) || (pobiRight % 2 == 1) || (crongLeft % 2 == 0) || (crongRight % 2 == 1)
            || (pobiRight - pobiLeft != 1) || (crongRight - crongLeft != 1)){
            return -1;
        }

        if((pobiLeft < 1) || (pobiLeft > 399) || (pobiRight < 2) || (pobiRight > 400)) {
            return -1;
        }

        if((crongLeft < 1) || (crongLeft > 399) || (crongRight < 2) || (crongRight > 400)) {
            return -1;
        }


        pSum = calculator.sum(pobiLeft, pobiRight);
        pMul = calculator.mul(pobiLeft, pobiRight);
        cSum = calculator.sum(crongLeft, crongRight);
        cMul = calculator.mul(crongLeft, crongRight);

        pScore = Math.max(pSum, pMul);
        cScore = Math.max(cSum, cMul);

        if(pScore > cScore){
            answer = 1;
        } else if(pScore < cScore) {
            answer = 2;
        } else if (pScore == cScore) {
            answer = 0;
        }

        return answer; // answer == 1 or 2 or 0 or -1
    }
}