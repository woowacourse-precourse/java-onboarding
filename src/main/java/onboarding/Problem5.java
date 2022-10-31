package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneys = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = exchangeMoney(moneys, money);
        return answer;
    }

    public static List<Integer> exchangeMoney(List<Integer> moneys, int money) {
        int idx = 0;
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < moneys.size(); i++) {
            cnt = money / moneys.get(idx);
            if (cnt == 0) {
                result.add(idx, cnt);
                idx += 1;
                continue;
            }
            money -= cnt * moneys.get(idx);
            result.add(idx, cnt);
            idx += 1;
        }
        return result;
    }
}
