package onboarding;

import java.util.LinkedList;
import java.util.List;

class MoneyClassifier {
    /*
        Descending Order
     */
    private static final int[] MONETARY_UNIT = {
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
    };

    public static List<Integer> classify(int money) {
        List<Integer> classifiedList = new LinkedList<>();
        for (int monetaryUnit : MONETARY_UNIT) {
            classifiedList.add(money / monetaryUnit);
            money = money % monetaryUnit;
        }
        return classifiedList;
    }
}

public class Problem5 {
    public static List<Integer> solution(int money) {
        return MoneyClassifier.classify(money);
    }
}
