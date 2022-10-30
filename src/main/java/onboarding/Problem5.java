package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneyTypes =
                new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        List<Integer> answer = Collections.emptyList();
        answer = getDivList(money, moneyTypes);
        return answer;
    }

    /**
     * Function for finding div using greedy
     **/
    private static List<Integer> getDivList(int money, List<Integer> moneyTypes) {
        List<Integer> div_list = new ArrayList<>();
        for (int i = 0; i < moneyTypes.size(); i++) {
            int value = moneyTypes.get(i);
            int div = money/value;
            money -= div*value;
            div_list.add(div);
        }
        return div_list;
    }
}
