package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> CASH_LIST = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return changeCashList(money);
    }

    /**
     * 계좌의 금액을 화폐로 바꾸는 기능
     */
    public static List<Integer> changeCashList(int money){
        List<Integer> changeCashList = new ArrayList<>();

        for(Integer cash : CASH_LIST){
            changeCashList.add(money / cash);
            money %= cash;
        }

        return changeCashList;
    }

}
