package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] kind_of_money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int remain_money = money;
        for (int won: kind_of_money) {
            if (won > remain_money) {
                answer.add(0);
                continue;
            }
            int won_count = remain_money / won;
            answer.add(won_count);
            remain_money -= won_count * won;
        }
        return answer;
    }
}
