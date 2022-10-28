package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int bill[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int cnt = 0;
        int i = 0;

        while (money >= 0 && i < bill.length) {
            if (money >= bill[i]) {
                money -= bill[i];
                cnt++;
            }
            else {
                answer.add(cnt);
                cnt = 0;
                i++;
            }
        }
        return answer;
    }
}
