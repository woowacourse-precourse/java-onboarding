package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//성공
public class Problem5 {
    public static List<Integer> solution(int money) {

//        돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로
//        변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
        List<Integer> answer = new ArrayList<>();

        answer.add((int)money/50000);
        money = (int)((money -50000*answer.get(0)));

        answer.add((int)money/10000);
        money = (int)((money -10000*answer.get(1)));

        answer.add((int)money/5000);
        money = (int)((money -5000*answer.get(2)));

        answer.add((int)money/1000);
        money = (int)((money -1000*answer.get(3)));

        answer.add((int)money/500);
        money = (int)((money -500*answer.get(4)));

        answer.add((int)money/100);
        money = (int)((money -100*answer.get(5)));

        answer.add((int)money/50);
        money = (int)((money -50*answer.get(6)));

        answer.add((int)money/10);
        money = (int)((money -10*answer.get(7)));

        answer.add((int)money/1);






        return answer;
    }
}
