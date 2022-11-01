package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if(money >= 50000) {
            answer.add(money/50000);
            money -= (50000*answer.get(0));
        }
        else {
            answer.add(0);
        }
        if(money >= 10000) {
            answer.add(money/10000);
            money -= (10000*answer.get(1));
        }
        else {
            answer.add(0);
        }
        if(money >= 5000) {
            answer.add(money/5000);
            money -= (5000*answer.get(2));
        }
        else {
            answer.add(0);
        }
        if(money >= 1000) {
            answer.add(money/1000);
            money -= (1000*answer.get(3));
        }
        else {
            answer.add(0);
        }
        if(money >= 500) {
            answer.add(money/500);
            money -= (500*answer.get(4));
        }
        else {
            answer.add(0);
        }
        if(money >= 100) {
            answer.add(money/100);
            money -= (100*answer.get(5));
        }
        else {
            answer.add(0);
        }
        if(money >= 50) {
            answer.add(money/50);
            money -= (50*answer.get(6));
        }
        else {
            answer.add(0);
        }
        if(money >= 10) {
            answer.add(money/10);
            money -= (10*answer.get(7));
        }
        else {
            answer.add(0);
        }
        if(money >= 1) {
            answer.add(money/1);
            money -= (1*answer.get(8));
        }
        else {
            answer.add(0);
        }


        return answer;
    }
}
