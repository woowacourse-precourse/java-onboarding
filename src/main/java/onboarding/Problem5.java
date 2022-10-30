package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] money_arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int left_money = money;
        int count = 0;
        for (int j : money_arr) {
            count = changeMoney(left_money, j);
            answer.add(count);
            if(count != 0) left_money -= (j * count);
        }
        return answer;
    }
    public static Integer changeMoney(int money, int using_money) {
        return money / using_money;
    }
}
