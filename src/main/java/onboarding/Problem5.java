package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if(hasException(money)){
            return null;
        }
        return answer;
    }

    public static boolean hasException(int money){
        if(money < 1 || money > 1000000)
            return true;
        return false;
    }
}
