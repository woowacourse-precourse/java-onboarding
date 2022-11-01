package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        answer.add(0,find50000(money));
        money%=50000;
        answer.add(1, find10000(money));
        money%=10000;
        answer.add(2, find5000(money));
        money%=5000;
        answer.add(3, find1000(money));
        money%=1000;
        answer.add(4, find500(money));
        money%=500;
        answer.add(5, find100(money));
        money%=100;
        answer.add(6, find50(money));
        money%=50;
        answer.add(7, find10(money));
        money%=10;
        answer.add(8, find1(money));
        money%=1;

        return answer;
    }

    public static boolean isInRange(Integer Money){
        if(Money >= 1 && Money <= 50000)
            return true;

        return false;
    }

    public static Integer find50000(Integer money){
        return money/50000;
    }

    public static Integer find10000(Integer money){
        return money/10000;
    }

    public static Integer find5000(Integer money){
        return money/5000;
    }

    public static Integer find1000(Integer money){
        return money/1000;
    }

    public static Integer find500(Integer money) {
        return money / 500;
    }

    public static Integer find100(Integer money) {
        return money / 100;
    }

    public static Integer find50(Integer money) {
        return money / 50;
    }

    public static Integer find10(Integer money) {
        return money / 10;
    }
    public static Integer find1(Integer money) {
        return money / 1;
    }
}
