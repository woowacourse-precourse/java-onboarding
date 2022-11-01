package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return changeMoney(money);
    }

    static int[] changes = {50000, 10000,  5000, 1000, 500, 100, 50, 10, 1};

    static List changeMoney(int money){
        List<Integer> changelist = new ArrayList<>();
        for (int i = 0; i < changes.length; i++) {
            changelist.add(money / changes[i]);
            money %= changes[i];
        }
        return changelist;
    }
}
