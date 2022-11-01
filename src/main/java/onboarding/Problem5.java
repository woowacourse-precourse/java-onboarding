package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] money_lst = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int j : money_lst) {
            money = getChanges(money, answer, j);
        }
        return answer;
    }

    /**
     * 큰 액수의 화폐를 최대한 많이 사용하여 변환
     **/
    private static int getChanges(int money, List<Integer> answer, int money_lst) {
        int num = money / money_lst;
        answer.add(num);
        money = money % money_lst;
        return money;
    }
}
