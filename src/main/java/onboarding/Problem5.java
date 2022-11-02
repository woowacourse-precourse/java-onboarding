package onboarding;

import problem5.AccountWithDraw;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        AccountWithDraw accountWithDraw = new AccountWithDraw(money);
        List<Integer> answer = accountWithDraw.withDraw();
        return answer;
    }
}
