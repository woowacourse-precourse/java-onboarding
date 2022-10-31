package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneyTable = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        List<Integer> resultTable = new ArrayList<>(Collections.nCopies(moneyTable.size(), 0));


        for (int i = 0; i < moneyTable.size(); i++) {
            resultTable.set(i, money / moneyTable.get(i));
            money = money % moneyTable.get(i);
        }

        return resultTable;
    }
}
