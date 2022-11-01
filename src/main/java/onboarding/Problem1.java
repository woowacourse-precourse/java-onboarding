package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        // 예외사항 검증
        if (pobiLeft <= 1 || crongLeft <= 1 || pobiRight >= 400 || crongRight >= 400 || pobiRight-pobiLeft != 1 || crongRight-crongLeft != 1 ){
            return -1;
        }

        int calculatePobi[] = {0, 1, 0, 1};
        int calculateCrong[] = {0, 1, 0, 1};

        while(pobiLeft>0){
            calculatePobi[0] = calculatePobi[0]+pobiLeft%10;
            calculatePobi[1] = calculatePobi[1]*(pobiLeft%10);
            pobiLeft = pobiLeft/10;
        }

        while(pobiRight>0){
            calculatePobi[2] = calculatePobi[2]+pobiRight%10;
            calculatePobi[3] = calculatePobi[3]*(pobiRight%10);
            pobiRight = pobiRight/10;
        }

        while(crongLeft>0){
            calculateCrong[0] = calculateCrong[0]+crongLeft%10;
            calculateCrong[1] = calculateCrong[1]*(crongLeft%10);
            crongLeft = crongLeft/10;
        }

        while(crongRight>0){
            calculateCrong[2] = calculateCrong[2]+crongRight%10;
            calculateCrong[3] = calculateCrong[3]*(crongRight%10);
            crongRight = crongRight/10;
        }

        java.util.Arrays.sort(calculatePobi);
        java.util.Arrays.sort(calculateCrong);
        if(calculatePobi[3] > calculateCrong[3]){
            answer = 1;
        }else if (calculatePobi[3] < calculateCrong[3]){
            answer = 2;
        }else{
            answer = 0;
        }

        return answer;
    }
}