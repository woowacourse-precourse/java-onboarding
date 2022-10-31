package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < cash.length; i++) {
            int a = money / cash[i]; // 각 지폐/동전 개수
            money %= cash[i]; // 나머지 값
            answer.add(a);
        }
        return answer;
    }
    /*
    public static void main(String[] args) { // TEST
        int money = 15000;

        solution(money);
    }

     */

}
