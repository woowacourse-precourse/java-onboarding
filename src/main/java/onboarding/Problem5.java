package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static int[] exchageList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        answer = getCountOfMoneyList(money);

        return answer;
    }

    public static List<Integer> getCountOfMoneyList(int money) {
        List<Integer> result = new ArrayList<Integer>();
        int count;
        for(int i = 0; i < exchageList.length; i++) {
            count = money / exchageList[i];
            result.add(count);
            money -= count * exchageList[i];
        }
        return result;
    }
}
