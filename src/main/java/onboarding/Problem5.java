package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        try {
            checkNumberRange(money);
            return answer;
        }catch (Exception e){
            return answer;
        }
    }
    public static void checkNumberRange(int money_range) throws Exception {
        if (money_range<1||money_range>1000000) throw new Exception("숫자 범위 초과");
    }
}
