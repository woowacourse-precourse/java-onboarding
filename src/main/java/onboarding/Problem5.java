package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    //  Static-Variable
    private static final int[] exchange = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        //  Variable
        List<Integer> answer = new ArrayList<>();
        //  For-Loop : 큰 금액의 화폐부터 교환이 가능한지 계산
        for(int i = 0; i < exchange.length; i++){
            answer.add(checkExchange(money, i));
            money = reminderExchange(money, i);
        }

        return answer;
    }

    //  교환하려는 화폐의 개수를 구하는 메소드
    private static int checkExchange(int money, int index){
        return money / exchange[index];
    }

    //  교환하지 못한 나머지 금액을 계산하는 메소드
    private static int reminderExchange(int money, int index) {
        return money % exchange[index];
    }
}
