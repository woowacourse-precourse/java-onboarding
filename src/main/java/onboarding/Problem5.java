package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = List.of();
        int[] unitList = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        List<Integer> result = new ArrayList<>();
        int change = money;
        for (int i=0;i<unitList.length; i++) {
            result.add(1);
            change = calculate(change, unitList[i], result, i);
        }

        answer = result;
        return answer;
    }

    public static int calculate(int money, int unit, List<Integer> list, int index){
        if (money/unit < 0)
            list.set(index, 0);
        else
            list.set(index, money/unit);
        return money%unit;
    }
}
