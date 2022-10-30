package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> moneyTypes = makeMoneyTypes();

        answer = getMoneyIngredients(money, moneyTypes);

        return answer;
    }

    static List<Integer> makeMoneyTypes() {
        return List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
    }

    static List<Integer> getMoneyIngredients(int money, List<Integer> moneyTypes) {
        List<Integer> temp = new ArrayList<>();

        for (Integer moneyType : moneyTypes) {
            temp.add(money / moneyType);
            money = money % moneyType;
        }

        return temp;
    }
}
