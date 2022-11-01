package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] unitArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<9; i++) {
            List<Integer> unitList = unitCalc(money, unitArr[i]);
            answer.add(unitList.get(0));
            money = unitList.get(1);
        }

        return answer;
    }

    static List<Integer> unitCalc(int money, int unit) {
        List<Integer> list = new ArrayList<>();

        int quo = money / unit;
        int rem = money - (quo * unit);
        list.add(quo);
        list.add(rem);

        return list;
    }
}
