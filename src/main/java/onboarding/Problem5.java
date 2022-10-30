package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] unitList = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
        int change = money;
        for (int i=0;i<unitList.length; i++) {
            answer.add(1);
            change = calculate(change, unitList[i], answer, i);
        }

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
