package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public  static  void catchException(int num){
        assert (num>=1);
        assert (num<1000000);
    }
    public static List<Integer> solution(int money) {
        catchException(money);
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
