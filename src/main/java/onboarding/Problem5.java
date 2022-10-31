package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 기능
 * 1. 화폐 개수를 리턴하는 함수
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        return calcCoins(money);
    }

    /**
     * 1. 화폐 개수를 리턴하는 함수
     * @param money
     * @return 화폐 개수가 담긴 리스트
     */
    static List<Integer> calcCoins(int money){
        List<Integer> currency = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> coins = new ArrayList<>();
        for(int curCurrency : currency){
            if(money < curCurrency){
                coins.add(0);
            } else if (money >= curCurrency) {
                coins.add(money/curCurrency);
                money -= (money/curCurrency) * curCurrency;
            }
        }
        return coins;
    }

}
