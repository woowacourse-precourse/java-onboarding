package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        try {
            if (money < 1 || money > 1000000)
                throw new Exception("돈의 범위가 잘못되었습니다");
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();
        int moneyList[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < moneyList.length; i++) {
            answer.add(money/moneyList[i]);
            money %= moneyList[i];
        }
        return answer;
    }
}
/**
  가장 큰단위 화폐를 위주로 돈을 넣어 준다.
  오만, 만, 오천, 천, 오백, 백, 오십, 십, 일원 순서대로 리스트로 반환
 */