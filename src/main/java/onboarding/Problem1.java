package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiValue, crongValue;
        Integer pobiLeft = pobi.get(0);
        Integer pobiRight = pobi.get(1);
        Integer crongLeft = crong.get(0);
        Integer crongRight = crong.get(1);

        if(pobiRight - pobiLeft != 1 || crongRight - crongLeft != 1) return -1;
        if(pobiLeft < 1 || pobiRight > 400 || crongLeft < 0 || crongRight > 400) return -1;
        if(pobiLeft == 1 || crongLeft == 1 || pobiRight == 400 || crongRight == 400) return -1;
        int pobiLeftSolution = subSolution(pobiLeft);
        int pobiRightSolution = subSolution(pobiRight);
        int crongLeftSolution = subSolution(crongLeft);
        int crongRightSolution = subSolution(crongRight);

        if(pobiLeftSolution >= pobiRightSolution) pobiValue = pobiLeftSolution;
        else pobiValue = pobiRightSolution;
        if(crongLeftSolution >= crongRightSolution) crongValue = crongLeftSolution;
        else crongValue = crongRightSolution;

        if(pobiValue > crongValue) return 1;
        else if (pobiValue == crongValue) return 0;
        else return -2;
    }

    public static int subSolution(int input){
        int tmpAdd = 0;
        int tmpMulti = 1;
        while(input > 0){
            int cur = input % 10;
            tmpAdd += cur;
            tmpMulti *= cur;
            input = input / 10;
        }
        if(tmpAdd >= tmpMulti) return tmpAdd;
        else return tmpMulti;
    }
}