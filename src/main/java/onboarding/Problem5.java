package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Problem5 {

    // 1. 예외처리 : money가 1~1,000,000 사이인지 체크
    public static boolean isException(Integer money){
        if(money >= 1 && money <= 1000000){
            return true;
        }
        return false;
    }

    // 2. 큰 금액부터 순서대로 값을 구하는 함수 만들기.
    public static List<Integer> getMoeny(Integer money){
        List<Integer> money_list = new ArrayList<>();
        List<Integer> moneys = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        for(int i = 0; i< moneys.size(); i++){
            money_list.add(i, money / moneys.get(i));
            if(money >= moneys.get(i)){
                money = money%moneys.get(i);
            }
        }
        return money_list;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        if(isException(money)){
            answer = getMoeny(money);
        }
        return answer;
    }
}
