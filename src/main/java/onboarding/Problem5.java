package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = countHowManyChange(money);

        return answer;
    }

    private static List countHowManyChange(int money) {
        List<Integer> listOfChanges = new ArrayList<>();
        int[] kindOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int count;

        for (int i = 0; i < kindOfMoney.length; i++) {
            count = money / kindOfMoney[i];
            money %= kindOfMoney[i];
            listOfChanges.add(count);
        }

        return listOfChanges;
    }
}
