package onboarding;

import java.util.ArrayList;
import java.util.List;

// <기능 목록>
// 1. 화폐로 변환하기

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] currencyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};   // 화폐단위

        answer = List.copyOf(changeMoney(money, currencyUnit));
        return answer;
    }

    // 1. 화폐로 변환하기
    public static List<Integer> changeMoney(int money, int[] currencyUnit) {
        List<Integer> currency = new ArrayList<>();

        for (int u : currencyUnit) {
            currency.add((Integer) (money / u));
            money %= u;
        }
        return currency;
    }

}
