package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int[] cash = {50000,10000,5000,1000,500,100,50,10,1};

        for (int i = 0; i < cash.length; i++) {
            int count = money / cash[i];
            answer.add(count);
            money -= cash[i] * count;

            if (money == 0){
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
//        int money = 50237;
        int money = 15000;
        System.out.println(solution(money));
    }
}
