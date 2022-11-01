package onboarding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=new ArrayList<Integer>();

        // 50000원권 장 수
        if (money >= 50000) {
            answer.add(money/50000);
            money = money % 50000;
        }else{answer.add(0);}

        // 10000원권 장 수
        if (money >= 10000) {
            answer.add(money / 10000);
            money = money % 10000;
        }else{answer.add(0);}

        // 5000원권 장 수
        if (money >= 5000) {
            answer.add(money / 5000);
            money = money % 5000;
        }else{answer.add(0);}

        // 1000원권 장 수
        if (money >= 1000) {
            answer.add(money / 1000);
            money = money % 1000;
        }else{answer.add(0);}

        // 500원 개 수
        if (money >= 500) {
            answer.add(money / 500);
            money = money % 500;
        }else{answer.add(0);}

        // 100원 개 수
        if (money >= 100) {
            answer.add(money / 100);
            money = money % 100;
        }else{answer.add(0);}

        // 50원 개 수
        if (money >= 50) {
            answer.add(money / 50);
            money = money % 50;
        }else{answer.add(0);}

        // 10원 개 수
        if (money >= 10) {
            answer.add(money / 10);
            money = money % 10;
        }else{answer.add(0);}

        // 1원 개 수
        if (money >= 1) {
            answer.add(money / 1);
            money = money % 1;
        }else{answer.add(0);}

        return answer;
    }
}