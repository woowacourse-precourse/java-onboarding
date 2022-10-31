package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        System.out.println("pobi: "+ Arrays.toString(pobi.toArray()));
        System.out.println("crong: "+Arrays.toString(crong.toArray()));
        //예외 사항이 나오면 -1 리턴
        int exceptionCase = -1;
        if(pobi.get(0) <= 1 || crong.get(0) <= 1) return exceptionCase;
        if(pobi.get(1) >= 400 || crong.get(1) >= 400) return exceptionCase;
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) return exceptionCase;

        int answer = Integer.MAX_VALUE;
        return answer;
    }
}