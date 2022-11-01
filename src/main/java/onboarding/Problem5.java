package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return withdraw(money);
    }

    public static List<Integer> withdraw(int money) {
        ArrayList<Integer> moneys = new ArrayList<>();

        moneys.add(money / 50000);
        money -= moneys.get(0) * 50000;

        moneys.add(money / 10000);
        money -= moneys.get(1) * 10000;

        moneys.add(money / 5000);
        money -= moneys.get(2) * 5000;

        moneys.add(money / 1000);
        money -= moneys.get(3) * 1000;

        moneys.add(money / 500);
        money -= moneys.get(4) * 500;

        moneys.add(money / 100);
        money -= moneys.get(5) * 100;

        moneys.add(money / 50);
        money -= moneys.get(6) * 50;

        moneys.add(money / 10);
        money -= moneys.get(7) * 10;

        moneys.add(money);

        return moneys;
    }
}
