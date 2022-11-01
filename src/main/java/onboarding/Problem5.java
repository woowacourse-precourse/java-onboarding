package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<Integer>();
        int[] currencies = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int tempMoney = money;
        int count = 0;

        for (int i = 0; i < currencies.length; i++) {
            count = tempMoney / currencies[i];
            answer.add(count);
            tempMoney = tempMoney % currencies[i];
        }

        return answer;
    }
}
