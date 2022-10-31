package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static List<Integer> list = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10);

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int count = 0;
            while (money >= list.get(i)) {
                count++;
                money -= list.get(i);
            }
            ans.add(count);
        }
        ans.add(money);
        answer = ans;
        return answer;
    }
}
