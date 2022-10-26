package onboarding;

import java.util.List;
import java.lang.Math;

class Problem1 {
    //check page
    public static boolean errChk(List<Integer> lst){
        if (lst.get(1) - lst.get(0) != 1){
            return true;
        }
        else if (lst.contains(1) || lst.contains(2) || lst.contains(399) || lst.contains(400)){
            return true;
        }
        return false;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (errChk(pobi) || errChk(crong)){
            return -1;
        }
        return answer;
    }
}