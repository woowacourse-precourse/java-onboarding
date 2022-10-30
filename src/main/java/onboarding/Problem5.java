package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return Wallet.pay(money);
    }
}
class Wallet{
    static int[] cate = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    static List<Integer> pay(int money){
        List<Integer> answer = new ArrayList<>();
        for (int bill : cate) {
                int coinCnt = money / bill;
                answer.add(coinCnt);
                money -= bill * coinCnt;
        }
        return answer;
    }
}
