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

    private static int countMillion() {
        int million = balance / 10000;
        balance -= 10000 * million;
        return million;
    }

    private static int countFiveThousand() {
        int thousand = balance / 1000;
        balance -= 1000 * thousand;
        return thousand;
    }

}
