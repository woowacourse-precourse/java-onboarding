package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {


    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        //큰 단위부터 나눈 몫을 차례로 리스트에 저장
        for (Integer moneyType : moneyTypes) {
            answer.add(money / moneyType);
            money %= moneyType;
        }
        return answer;
    }
}
