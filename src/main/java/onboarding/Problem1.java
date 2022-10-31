package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax=-0;
        int crongMax=0;
        boolean error = false;



        if (error) {
            answer=-1;
        } else if (pobiMax>crongMax) {
            answer=1;
        } else if (pobiMax<crongMax) {
            answer=2;
        } else if (pobiMax==crongMax) {
            answer=0;
        }
        return answer;
    }
}

