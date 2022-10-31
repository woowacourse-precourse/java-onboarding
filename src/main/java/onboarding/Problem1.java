package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(!exceptionCheck(pobi) || !exceptionCheck(crong)){return -1;}
        return answer;
    }
    static boolean exceptionCheck(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if(left+1 != right) {return false;}
        if(left%2 == 0) {return false;}
        if(left < 1 || left > 400) {return false;}
        if(right <1 || right > 400) {return false;}
        return true;
    }
}