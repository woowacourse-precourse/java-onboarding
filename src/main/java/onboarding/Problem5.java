package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 문제 분석
 * 1. 잔돈의 개수를 최저한으로 받을수 있는 경우를 구하는 문제이다.
 * 해당 문제의 경우 잔돈의 종류를 보았을때 모든 하위 단위 화페로 상위 단위 화폐를 만들어 낼수있다.
 * ex) 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 단위의 화페가 존재할때
 * 10 == 10 * 1
 * 50 == 5 * 10
 * 100 == 2 * 50
 * 500 == 5 * 100
 * 1000 == 2 * 500
 * 5000 == 5 * 1000
 * 10000 == 2 * 5000
 * 50000 == 5 * 10000
 * 이므로 모든 경우 하위 단위 화페로 상위 단위 화폐를 만들어낼수가 있다.
 * 2. 1번 분석 을 근거로 해당 문제는 그리디 알고리즘으로 해결할수있다.
 * 즉, 상위 단위 화폐부터 하위 단위 화폐순으로 잔돈을 거슬러주면 해결된다.
 */
public class Problem5 {
    static int[] moneys = {
            50000,10000,5000,1000,500,100,50,10,1
    };
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < moneys.length; i++) {
            answer.add(money / moneys[i]);
            money %= moneys[i];
        }

        return answer;
    }
}
