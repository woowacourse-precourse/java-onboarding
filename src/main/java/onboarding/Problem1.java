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

    public static Integer sumDigit (Integer num){
        int sum=0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public static Integer multiplyDigit (Integer num){
        int multiply=1;
        while(num > 0){
            multiply *= num%10;
            num /= 10;
        }
        return multiply;
    }

    public static Boolean isInRange(List<Integer> page){
        if(page.get(LEFT.ordinal()) > 1
        && page.get(RIGHT.ordinal()) < 400)
            return true;
        else return false;
    }

    public static Boolean isOdd(Integer num){
        if(num%2==1)
            return true;
        return false;
    }

    public static Boolean isEven(Integer num){
        if(num%2==0)
            return true;
        return false;
    }
}