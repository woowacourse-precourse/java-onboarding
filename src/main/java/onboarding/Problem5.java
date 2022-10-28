package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

//    public static void main(String[] args) {
//        int money = 50237;
//        System.out.println("solution(money) = " + solution(money));
//    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] temp = new int[moneyType.length];

        for (int i = 0; i < moneyType.length; i++) {
            temp[i] += money/moneyType[i];
            money %= moneyType[i];
            answer.add(temp[i]);
        }
        return answer;
    }
}
