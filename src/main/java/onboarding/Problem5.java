package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int balance;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        balance = money;
        return answer;
    }

    private static int countFiveMillion() {
        int fiveMillion = balance / 50000;
        balance -= 50000 * fiveMillion;
        return fiveMillion;
    }

}
