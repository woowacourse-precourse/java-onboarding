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
        int count = balance / 50000;
        balance -= 50000 * count;
        return count;
    }

    private static int countMillion() {
        int count = balance / 10000;
        balance -= 10000 * count;
        return count;
    }

    private static int countFiveThousand() {
        int count = balance / 5000;
        balance -= 5000 * count;
        return count;
    }

    private static int countThousand() {
        int count = balance / 1000;
        balance -= 1000 * count;
        return count;
    }

    private static int countFiveHundred() {
        int count = balance / 500;
        balance -= 500 * count;
        return count;
    }

    private static int countThousand() {
        int thousand = balance / 1000;
        balance -= 1000 * thousand;
        return thousand;
    }

    private static int countThousand() {
        int thousand = balance / 1000;
        balance -= 1000 * thousand;
        return thousand;
    }

    private static int countThousand() {
        int thousand = balance / 1000;
        balance -= 1000 * thousand;
        return thousand;
    }

}
