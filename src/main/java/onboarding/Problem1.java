package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = Integer.MIN_VALUE;
        int crongScore = Integer.MIN_VALUE;
        int tempScore;
        int value;

        if(pobi.get(0)<3 || pobi.get(0)>398 || pobi.get(1)<3 || pobi.get(1)>398) answer=-1;
        else if(crong.get(0)<3 || crong.get(0)>398 || crong.get(1)<3 || crong.get(1)>398) answer=-1;
        else if(pobi.get(0)%2==0 || pobi.get(1)%2==1 || crong.get(0)%2==0 || crong.get(1)%2==1) answer=-1;
        else if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1) ) answer=-1;

        if(answer == -1) return answer;

        for(tempScore=0, value=pobi.get(0); value!=0; value/=10) tempScore += value%10;
        pobiScore = pobiScore > tempScore ? pobiScore : tempScore;
        for(tempScore=0, value=pobi.get(1); value!=0; value/=10) tempScore += value%10;
        pobiScore = pobiScore > tempScore ? pobiScore : tempScore;
        for(tempScore=1, value=pobi.get(0); value!=0; value/=10) tempScore *= value%10;
        pobiScore = pobiScore > tempScore ? pobiScore : tempScore;
        for(tempScore=1, value=pobi.get(1); value!=0; value/=10) tempScore *= value%10;
        pobiScore = pobiScore > tempScore ? pobiScore : tempScore;

        for(tempScore=0, value=crong.get(0); value!=0; value/=10) tempScore += value%10;
        crongScore = crongScore > tempScore ? crongScore : tempScore;
        for(tempScore=0, value=crong.get(1); value!=0; value/=10) tempScore += value%10;
        crongScore = crongScore > tempScore ? crongScore : tempScore;
        for(tempScore=1, value=crong.get(0); value!=0; value/=10) tempScore *= value%10;
        crongScore = crongScore > tempScore ? crongScore : tempScore;
        for(tempScore=1, value=crong.get(1); value!=0; value/=10) tempScore *= value%10;
        crongScore = crongScore > tempScore ? crongScore : tempScore;

        if(pobiScore > crongScore) answer = 1;
        else if(pobiScore < crongScore) answer = 2;
        else if(pobiScore == crongScore) answer = 0;

        return answer;
    }
}