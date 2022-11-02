package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        Withdraw withdraw = new Withdraw(money);

        if(withdraw.exception() == -1) {
            answer.add(-1);
        } else {
            answer = withdraw.change();
        }

        return answer;
    }
}
