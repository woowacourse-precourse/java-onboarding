package onboarding;

//기능1. 지폐와 동전의 단위가 담긴 배열을 만든다
//기능2. 가장 큰 지폐보다 금액이 크면 나누고 아니면 그 다음으로 큰 지폐나 동전으로 나눈뒤 몫은 answer 에 add.
//기능3. 기능1~3을 반복문으로 만든다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
//        List<Integer> answer = Collections.emptyList(); //add, get 불가
        List<Integer> answer = new ArrayList<>(); //add, get 가능

        int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i=0;i< coins.length;i++) {
            if (money >= coins[i]) {
                answer.add(money / coins[i]);
                money = money- coins[i]*(money/coins[i]);
            } else {
                answer.add(0);
            }
        }
        return answer;
    }
}
