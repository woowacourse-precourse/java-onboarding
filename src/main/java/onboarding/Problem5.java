package onboarding;

import model.Debits;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Debits debits = new Debits(money);
        return debits.getDebitsDetail();
    }
}
