package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(18);

        for(int m = 50000; m > 9; m /= (answer.size() & 1) == 1 ? 5 : 2){
            answer.add(money / m);
            money %= m;
        }
        answer.add(money);

        return answer;
    }
}
