package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(0) != pobi.get(1) -1 || crong.get(0) != crong.get(1)-1){
            return -1;
        }


        return answer;
    }
}