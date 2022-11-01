package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        //예외사항 : money의 범위가 1~1000,000을 벗어나는 경우

        if (money > 1000000 || money < 1) {
            System.out.println("Please, Enter money range 1~1000,000");
            return Collections.emptyList();
        }

        List<Integer> moneyUnitArray = new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1)); //화폐 단위 배열 만들기

        int numberOfKindOfMoney = moneyUnitArray.size(); //화폐 단위 개수구하기

        for (int i = 0; i < numberOfKindOfMoney ; i++) { // 50000원권 부터 순서대로 나눠주면서 answer 배열에 저장하기
            answer.add(money/moneyUnitArray.get(i));
            money %= moneyUnitArray.get(i);
        }


        return answer;
    }
}
