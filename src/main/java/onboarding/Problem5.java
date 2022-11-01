package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Programs should be written for people to read, and only incidentally for machine to execute
 */

public class Problem5 {
    // 우선순위를 보장하기 위한 LinkedHashMap 지갑
    private static Map<Integer, Integer> wallet = new LinkedHashMap<>();

    public static List<Integer> solution(int money) {
        setWallet(); // 지갑 초기화
        exchangeMoney(money); // 환전 시작
        List<Integer> answer =  Collections.emptyList();
        answer = wallet.values().stream().collect(Collectors.toList());
        return answer;
    }

    /**
     * 지갑에 들어갈 수 있는 화폐의 종류를 모두 0개로 setting
     */

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

    /**
     * 큰 금액의 화폐가 우선순위로 금액을 환전 해주는 함수
     */

    private static void exchangeMoney(int money){
        int leftMoney = money; // 화폐별로 환전 후 남은 금액.
        for(Integer currency: wallet.keySet()){
            int numberOfCurrency = Math.floorDiv(leftMoney, currency); // 화폐별 환전 가능 개수
            leftMoney = Math.floorMod(leftMoney, currency); // 환전 후 남은 금액
            wallet.replace(currency, numberOfCurrency); // 0에서 환전된 화폐 개수로 지갑 채우기
        }
    }
}
