package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static Integer calculateAmount(int iterator, int oldAmount) {
        int newAmount;
        //금액: 1
        if (iterator == 8) {
            newAmount = 1;
        }
        //금액: 50000,5000,500,50
        else if (iterator % 2 == 0) {
            newAmount = oldAmount / 2;
        }
        //금액: 10000,1000,100,10
        else {
            newAmount = oldAmount / 5;
        }
        return newAmount;
    }

    private static List<Integer> conversion(int amount, int money) {
        int result;
        //해당 금액으로 변환될 수 있다면 answer에 갯수 추가, or 0추가
        if (money >= amount) {
            result = money / amount;
            money = money % amount;
        } else {
            result = 0;
        }
        return List.of(money, result);
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int amount = 100000;
        for (int i = 0; i < 9; i++) {
            amount = calculateAmount(i, amount);
            List<Integer> result = conversion(amount, money);
            money = result.get(0);
            answer.add(result.get(1));
        }
        return answer;
    }

    public static void main(String args[]) {
        int money = 50237;
        System.out.println(solution(money));
    }

}
