package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {



    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0));

//        int[] answer = new int[]{0,0,0,0,0,0,0,0,0};
        while(money>0) {

            if (money >= 50000) {
                int tmp = money / 50000;
                money -= 50000 * tmp;
                answer.remove(0);
                answer.add(0, tmp);
            } else if (money >= 10000) {
                int tmp = money / 10000;
                money -= 10000 * tmp;
                answer.remove(1);
                answer.add(1, tmp);
            } else if (money >= 5000) {
                int tmp = money / 5000;
                money -= 5000 * tmp;
                answer.remove(2);
                answer.add(2, tmp);
            } else if (money >= 1000) {
                int tmp = money / 1000;
                money -= 1000 * tmp;
                answer.remove(3);
                answer.add(3, tmp);
            } else if (money >= 500) {
                int tmp = money / 500;
                money -= 500 * tmp;
                answer.remove(4);
                answer.add(4, tmp);
            } else if (money >= 100) {
                int tmp = money / 100;
                money -= 100 * tmp;
                answer.remove(5);
                answer.add(5, tmp);
            } else if (money >= 50) {
                int tmp = money / 50;
                money -= 50 * tmp;
                answer.remove(6);
                answer.add(6, tmp);
            } else if (money >= 10) {
                int tmp = money / 10;
                money -= 10 * tmp;
                answer.remove(7);
                answer.add(7, tmp);
            } else if (money >= 1) {
                int tmp = money / 1;
                money -= 1 * tmp;
                answer.remove(8);
                answer.add(8, tmp);
            }
        }
        return answer;
    }
}
