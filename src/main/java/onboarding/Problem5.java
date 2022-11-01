package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int balance;
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        balance = money;
        answer.add(countFiveMillion());
        answer.add(countMillion());
        answer.add(countFiveThousand());
        answer.add(countThousand());
        answer.add(countFiveHundred());
        answer.add(countHundred());
        answer.add(countFifty());
        answer.add(countTen());
        answer.add(countOne());
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

    private static int countHundred() {
        int count = balance / 100;
        balance -= 100 * count;
        return count;
    }

    private static int countFifty() {
        int count = balance / 50;
        balance -= 50 * count;
        return count;
    }

    private static int countTen() {
        int count = balance / 10;
        balance -= 10 * count;
        return count;
    }

    private static int countOne() {
        return balance;
    }


}
