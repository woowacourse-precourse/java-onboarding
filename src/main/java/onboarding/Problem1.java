package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;

        if (exceptionCheck(pobi,crong)){
            return -1;
        }

        int pobiScore = resultScore(pobi.get(0), pobi.get(1));
        int crongScore = resultScore(crong.get(0), crong.get(1));

        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore < crongScore){
            return 2;
        }

        return -1;
    }
}