package onboarding;

import java.util.List;

class Problem1 {
    /*
        check_except
        % input : page list [int, int]
        % output : boolean

        if list[1] - list[0] -> wrong page
     */
    public static boolean check_except(List<Integer> numbs){
        if(numbs.get(1) - numbs.get(0) != 1) return false;
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // if wrong page return -1
        if(!check_except(pobi)) return -1;
        if(!check_except(crong)) return -1;

        return answer;
    }
}