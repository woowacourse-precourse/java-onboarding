package onboarding;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static onboarding.LeftRight.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static Integer sumDigit (Integer page){
        int sum=0;
        while(page > 0){
            sum += page%10;
            page /= 10;
        }
        return sum;
    }

    public static Integer multiplyDigit (Integer page){
        int multiply=1;
        while(page > 0){
            multiply *= page%10;
            page /= 10;
        }
        return multiply;
    }

    public static Boolean isInRange(List<Integer> pages){
        if(pages.get(LEFT.ordinal()) > 1
        && pages.get(RIGHT.ordinal()) < 400)
            return true;
        else return false;
    }

    public static Boolean isOdd(Integer page){
        if(page%2==1)
            return true;
        return false;
    }

    public static Boolean isEven(Integer page){
        if(page%2==0)
            return true;
        return false;
    }

    public static Boolean isNotStartOrEnd(List<Integer> pages){
        if(pages.get(LEFT.ordinal()) == 0)
            return false;
        if(pages.get(RIGHT.ordinal()) == 400)
            return false;

        return true;
    }
}