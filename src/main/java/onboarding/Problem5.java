package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /**
     * 요구사항
     * 가장 적은 지폐와 동전 쓰게 만들기
     * 돈의 단위 {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}
     * 1<=money<=1,000,000
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        final int[] money_list = getMoney_list();
        for (int money_unit : money_list) {
            answer.add(divMoney(money , money_unit));
            money = remainderMoney(money, money_unit);
        }
        return answer;
    }
    //getMoney_list : 돈의 단위가 담긴 money_list 를 가져온다.
    private static int[] getMoney_list() {
        final int[] money_list = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        return money_list;
    }
    // remainderMoney : 돈을 화폐단위로 나눈 나머지를 리턴한다.
    private static int remainderMoney(int money, int money_unit) {
        return money % money_unit;
    }
    // divMoney : 돈을 화폐단위로 나눈 몫을 리턴한다.
    private static int divMoney(int money, int money_unit) {
        return money / money_unit;
    }
}