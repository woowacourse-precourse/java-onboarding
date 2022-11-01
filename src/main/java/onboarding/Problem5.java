package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        List<Integer> answer = new ArrayList<>(Collections.nCopies(9,0));
        while(money > 0) {
            if(money >= 50000) {
                answer.set(0,answer.get(0)+money / 50000);
                money %= 50000;
            } else if(money >= 10000) {
                answer.set(1,answer.get(1)+money / 10000);
                money %= 10000;
            } else if(money >= 5000) {
                answer.set(2,answer.get(2)+money / 5000);
                money %= 5000;
            } else if(money >= 1000) {
                answer.set(3,answer.get(3)+money / 1000);
                money %= 1000;
            } else if(money >= 500) {
                answer.set(4,answer.get(4)+money / 500);
                money %= 500;
            } else if(money >= 100) {
                answer.set(5,answer.get(5)+money / 100);
                money %= 100;
            } else if(money >= 50) {
                answer.set(6,answer.get(6)+money / 50);
                money %= 50;
            } else if(money >= 10) {
                answer.set(7,answer.get(7)+money / 10);
                money %= 10;
            } else {
                answer.set(8,answer.get(8)+money / 1);
                money /= 10;
            }
        }
        return answer;
    }
}
