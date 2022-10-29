package onboarding;

import java.util.List;

class Problem1 {
    public static boolean check_exception(List<Integer> li){
        int left = li.get(0); int right = li.get(1);
        if((left&1) == 0 || (right&1) == 1) return false;
        if(left + 1 != right) return false;
        if(left<1 || left>400) return false;
        if(right<1 || right>400) return false;
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}