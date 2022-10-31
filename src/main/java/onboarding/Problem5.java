package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


/**
 * 계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.<p>
 * 돈의 액수 money가 매개변수로 주어질 때,<p>
 * 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전<p>
 * 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.<p>
 * */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> coinTypes = asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        for (int type : coinTypes) {
            int a = money / type;
            answer.add(a);
            money = money % type;
        }

        return answer;
    }
}
