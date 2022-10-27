package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int rest_money;
    public static List<Integer> solution(int money) {
        rest_money = money;
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    public static int counting(int unit){
        int count = rest_money / unit;
        rest_money = rest_money % unit;
        return count;
    }
}
