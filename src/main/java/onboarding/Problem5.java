package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int [] count = new int [9];
        int [] unit = new int [9];

        unit[0] = 50000;
        unit[1] = 10000;
        unit[2] = 5000;
        unit[3] = 1000;
        unit[4] = 500;
        unit[5] = 100;
        unit[6] = 50;
        unit[7] = 10;
        unit[8] = 1;

        for(int i=0; i<9; i++){
            count[i] = money/unit[i];
            money %= unit[i];
            answer.add(count[i]);
        }

        return answer;
    }
    public static void main (String [] args) {

        int money = 237;

        Problem5 prob = new Problem5();
        System.out.println(prob.solution(money));
    }

}
