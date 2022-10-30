package onboarding;

/**
 * Money_divider
 *
 * 1. divide_in_order(int money) = 화폐가 큰 순서대로 money를 나눈다.
 * 2. save_result_get_left(int money, int divide) = money 를 divide 크기의 화페로 나눠서 결과를 저장하고 나눈 나머지를 반환
 * 3. save_result(int amount) = 결과를 저장한다.
 * 4. show_result() = 저장된 결과를 반환한다.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Money_divider money_divider = new Money_divider();
        money_divider.divide_in_order(money);
        return money_divider.show_result();
    }
}

class Money_divider{
    List<Integer> result;
    int order[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public void divide_in_order(int money){
        result = new ArrayList<>();
        for (int divide : order) {
            money = save_result_get_left(money, divide);
        }
    }

    private int save_result_get_left(int money, int divide) {
        save_result(money / divide);
        return money % divide;
    }

    private void save_result(int amout) {
        this.result.add(amout);
    }

    public List<Integer> show_result(){
        return this.result;
    }
}
