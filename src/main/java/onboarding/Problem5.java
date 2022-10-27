package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final List<Integer> ERROR = Collections.emptyList();
    static boolean Exception(int money) {
        return (0 < money && money < 1000000) ? false : true;
    }

    static int getMoneyType(int money) {
        if (money >= 50000)
            return 50000;
        else if (money >= 10000)
            return 10000;
        else if (money >= 5000)
            return 5000;
        else if (money >= 1000)
            return 1000;
        else if (money >= 500)
            return 500;
        else if (money >= 100)
            return 100;
        else if (money >= 50)
            return 50;
        else if (money >= 10)
            return 10;
        else if (money >= 1)
            return 1;
        return 0;
    }

    static  List<Integer> CashCount(int money) {
        List<Integer> result = new ArrayList<>(
                Collections.nCopies(9, 0)
        );
        int money_type;
        int money_index;
        int prev_val;
        List<Integer> money_index_list = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        while (money > 0) {
            money_type = getMoneyType(money);
            money_index = money_index_list.indexOf(money_type);
            prev_val = result.get(money_index);
            result.set(money_index, prev_val + 1);
            money -= money_type;
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer;

        if (Exception(money))
            return ERROR;

        answer = CashCount(money);

        return answer;
    }
}
