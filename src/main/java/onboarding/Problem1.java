package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = pageNumberException(pobi, crong);
        if(answer == -1){
            return answer;
        }
        return answer;
    }

    private static int pageNumberException(List<Integer> pobi, List<Integer> crong) {
        if((pobi.get(0)+1 != pobi.get(1)) || (crong.get(0)+1 != crong.get(1))){
            return -1;
        }
        return 0;
    }
}