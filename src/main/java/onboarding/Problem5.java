package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] units = {50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if(!(0 < money && money < 1000001)) return answer;

        for (int unit : units) {
            int cnt = exchange(unit, money);
            answer.add(cnt);
            money -= (unit * cnt);
        }
        return answer;
    }

    private static int exchange(int unit, int target) {
        return target / unit;
    }
}
