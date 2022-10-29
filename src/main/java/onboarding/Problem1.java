package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(((pobi.get(0)+1)!=(pobi.get(1)))||((crong.get(0)+1)!=(crong.get(1)))){
            answer=-1;
            return answer;
        }
        if((pobi.get(0)<1 || pobi.get(1)>400)||(crong.get(0)<1 || crong.get(1)>400)){
            answer=-1;
            return answer;
        }


        return answer;
    }
}