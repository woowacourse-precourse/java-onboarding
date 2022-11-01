package onboarding;

import java.util.List;
import java.util.ArrayList;
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] money_unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};  //화폐단위 별로 리스트 삽입

        for(int x = 0; x < money_unit.length; x++){ //제일 큰 화폐단위부터 순서대로 나눈다.
            answer.add(money / money_unit[x]);
            money %= money_unit[x];
        }
        return answer;
    }
}

