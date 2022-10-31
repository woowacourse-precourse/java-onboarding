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
    // plus
    public static int plus(List<Integer> lst){
        int left = lst.get(0);
        int right = lst.get(1);
        int plusLeft = (left/100 + (left/10)%10 + left%10);
        int plusRight = (right/100 + (right/10)%10 + right%10);
        return Math.max(plusLeft, plusRight);
    }
    // multiply
    public static int multi(List<Integer> lst){
        int left = lst.get(0);
        int right = lst.get(1);
        int multiLeft = 1;
        while(left>0){
            multiLeft += left%10;
            left /= 10;
        }
        int multiRight = 1;
        while(right>0){
            multiRight *= right%10;
            right /= 10;
        }
        return Math.max(multiLeft, multiRight);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (errChk(pobi) || errChk(crong)){
            return -1;
        }
        //compare
        int res_pobi = Math.max(plus(pobi), multi(pobi));
        int res_crong = Math.max(plus(crong), multi(crong));
        if (res_pobi > res_crong){
            answer = 1;
        }
        else if (res_pobi < res_crong){
            answer = 2;
        }
        else if (res_pobi == res_crong){
            answer = 0;
        }
        return answer;
    }
}