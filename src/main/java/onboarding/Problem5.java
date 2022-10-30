package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static Integer[] Money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> withdrawMoney(int money){
        int moneyCount = 0;
        List<Integer> moneyCountList = new ArrayList<>();
        for (Integer moneyValue : Money) {
            moneyCountList.add(money / moneyValue);
            money = money % moneyValue;
        }
        return moneyCountList;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withdrawMoney(money);
        return answer;
    }
}
