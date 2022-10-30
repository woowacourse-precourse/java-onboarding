package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Coins(money);
        return answer;
    }

    public static List<Integer> Coins(int coin){ // 돈이 주어지면 각 동전으로 변환하는 함수
        List<Integer> coins = new ArrayList<Integer>();
        List<Integer> coins_type = new ArrayList<Integer>();
        coins_type.add(50000);
        coins_type.add(10000);
        coins_type.add(5000);
        coins_type.add(1000);
        coins_type.add(500);
        coins_type.add(100);
        coins_type.add(50);
        coins_type.add(10);
        coins_type.add(1);

        for(int i : coins_type){
            coins.add(coin/i);
            coin %= i;
        }
        return coins;
    }
}
