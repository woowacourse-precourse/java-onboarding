package onboarding;

import java.util.List;
import java.util.Scanner;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiBig=0;
        int crongBig=0;
        int result;

        if (pobi.get(0)+1 != pobi.get(1)||crong.get(0)+1 != crong.get(1)) {
            answer = -1;
            return answer;
        }

        for (int i=0;i<pobi.size();i++) {
            result = calculate(pobi.get(i));
            if(pobiBig <= result){
                pobiBig = result;
            };
            result = calculate(crong.get(i));
            if(crongBig <= result){
                crongBig = result;
            }
        }
        if (pobiBig > crongBig)
            answer = 1;
        else if (pobiBig < crongBig)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    public static int calculate(int list) {
        int n = list;
        int value = 0;
        int rest;
        int plus = 0;
        int multiply = 1;
        while (n>0) {
            rest = n%10;
            plus += rest;
            multiply *= rest;
            n = n/10;
        }
        value = plus;
        if(plus <multiply){
            value = multiply;
        }
        return value;
    }

}