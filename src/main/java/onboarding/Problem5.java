package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> cash = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int i=0; i<cash.size(); i++) {
            int nBill = 0;
            if (money>=cash.indexOf(i)) {
                nBill = money/cash.get(i);
                money = money%cash.get(i);
            }
            answer.add(nBill);
        }
        return answer;
    }
}
