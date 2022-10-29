package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
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
    public static void main(String args[]) {
        System.out.println(divMoney(12000, 10000));
    }
}
