package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Programs should be written for people to read, and only incidentally for machine to execute
 */

public class Problem5 {
    private static Map<Integer, Integer> wallet = new LinkedHashMap<>();
    public static List<Integer> solution(int money) {
        setWallet();
        exchangeMoney(money);
        List<Integer> answer =  Collections.emptyList();
        answer = wallet.values().stream().collect(Collectors.toList());
        return answer;
    }

    private static void setWallet(){
        wallet.put(50000, 0);
        wallet.put(10000, 0);
        wallet.put(5000, 0);
        wallet.put(1000, 0);
        wallet.put(500, 0);
        wallet.put(100, 0);
        wallet.put(50, 0);
        wallet.put(10, 0);
        wallet.put(1, 0);
    }

    private static void exchangeMoney(int money){
        int leftMoney = money; 
        for(Integer currency: wallet.keySet()){
            int numberOfCurrency = Math.floorDiv(leftMoney, currency);
            leftMoney = Math.floorMod(leftMoney, currency);
            wallet.replace(currency, numberOfCurrency);
        }
    }
}
