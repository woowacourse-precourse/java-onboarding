package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
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
}
