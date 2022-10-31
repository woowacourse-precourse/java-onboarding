package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean exc = false;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int pobiMax = 0;

        // 예외사항
        if(pobiLeft < 1 || 400 < pobiRight)
            exc = true;
        if(pobiLeft%2 == 0)
            exc = true;
        if(pobiLeft + 1 != pobiRight)
            exc = true;

        // arr = {LeftSum, LeftMul, RightSum, RightMul}
        int[] pobiArr = new int[4];
        pobiArr[1] = 1;
        pobiArr[3] = 1;

        while(pobiLeft != 0 || pobiRight != 0) {
            pobiArr[0] += pobiLeft%10;
            if(pobiLeft != 0)
                pobiArr[1] *= pobiLeft%10;
            pobiArr[2] += pobiRight%10;
            if(pobiRight != 0)
                pobiArr[3] *= pobiRight%10;
            pobiLeft /= 10;
            pobiRight /= 10;
        }

        for(int i = 0; i < pobiArr.length; i++) {
            if(pobiMax <= pobiArr[i])
                pobiMax = pobiArr[i];
        }

        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);
        int crongMax = 0;

        // 예외사항
        if(crongLeft < 1 || 400 < crongRight)
            exc = true;
        if(crongLeft%2 == 0)
            exc = true;
        if(crongLeft + 1 != crongRight)
            exc = true;

        // arr = {LeftSum, LeftMul, RightSum, RightMul}
        int[] crongArr = new int[4];
        crongArr[1] = 1;
        crongArr[3] = 1;

        while(crongLeft != 0 || crongRight != 0) {
            crongArr[0] += crongLeft%10;
            if(crongLeft != 0)
                crongArr[1] *= crongLeft%10;
            crongArr[2] += crongRight%10;
            if(crongRight != 0)
                crongArr[3] *= crongRight%10;
            crongLeft /= 10;
            crongRight /= 10;
        }

        for(int i = 0; i < crongArr.length; i++) {
            if(crongMax <= crongArr[i])
                crongMax = crongArr[i];
        }

        if(exc)
            answer = -1;
        else if(pobiMax > crongMax)
            answer = 1;
        else if(pobiMax < crongMax)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}