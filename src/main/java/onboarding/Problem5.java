package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] billType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int bill: billType) {
            HashMap<String, Integer> map = divMoney(money, bill);
            money = map.get("remainder");
            answer.add(map.get("quotient"));
        }
        return answer;
    }

    static HashMap<String, Integer> divMoney(int money, int bill) {
        HashMap<String, Integer> map = new HashMap<>();
        int quotient = money / bill;
        int remainder = money % bill;
        map.put("quotient", quotient);
        map.put("remainder", remainder);
        return map;
    }
}
