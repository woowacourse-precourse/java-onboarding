package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static final List<Integer> StandardMoney = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static int[] divideMoney(int money, int price) {
        int count_money = 0;
        if(money / price != 0)
        {
            count_money = money / price;
            money = money - (price * count_money);
        }
        int[] result = {count_money,money};
        return result;
    }

    public static List<Integer> getMoney(int money) {
        List<Integer> classifyMoney = new ArrayList<>();

        for(int price : StandardMoney)
        {
            classifyMoney.add(divideMoney(money, price)[0]);
            money = divideMoney(money, price)[1];
        }
        return classifyMoney;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = getMoney(money);
        return answer;
    }
}
