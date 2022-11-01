package onboarding;

/**
 * [ Money_divider ]
 *  - int order[] = 제일 큰 화폐부터 작은 화폐까지 순서대로 나열한 배열
 *  - List<Integer> result = 변환할 수 있는 수를 나열할 리스트
 *
 *  - divide_in_order(int money) = 화폐가 큰 순서대로 money 를 나눈다.
 *  - save_result_get_left(int money, int divide) = money 를 divide 크기의 화페로 나눠서 결과를 저장하고 나눈 나머지를 반환
 *  - save_result(int amount) = 결과를 저장한다.
 *  - show_result() = 저장된 결과를 반환한다.
 */

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Money_divider money_divider = new Money_divider();
        money_divider.divide_in_order(money);
        return money_divider.show_result();
    }
}

class Money_divider {
    int order[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    List<Integer> result;

    public void divide_in_order(int money) {
        result = new ArrayList<>();
        for (int divide : order) {
            money = save_result_get_left(money, divide);
        }
    }

    private int save_result_get_left(int money, int divide) {
        save_result(money / divide);
        return money % divide;
    }

    private void save_result(int amount) {
        this.result.add(amount);
    }

    public List<Integer> show_result() {
        return this.result;
    }
}
