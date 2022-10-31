package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getAnswer(money); // 지갑이 최대한 가볍도록 화폐를 받는 경우
        return answer;
    }

    // 지갑이 최대한 가볍도록 화폐를 받는 경우를 List로 반환하는 함수
    private static List<Integer> getAnswer(int totalMoney) {
        // 화폐 목록 (금액이 큰 순으로 저장)
        List<Integer> moneyList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 금액이 큰 순서대로 화폐 각각 몇개씩으로 변환되는지를 저장하는 List
        List<Integer> quotientList = new ArrayList<>();

        // 돈의 나머지 액수
        int curMoney = totalMoney;
        // 현재 확인해야 하는 화폐보다 더 큰 금액의 화폐로 돈의 변환이 가능하다면,
        // 해당 더 큰 금액의 화폐에 대한 액수를 빼고 남은 값

        // 화폐 목록에 저장된 순서대로 확인
        for (Integer money : moneyList) {
            int quotient = curMoney / money; // curMoney를 화폐의 금액으로 나눴을 때 몫
            curMoney %= money; // curMoney를 화폐의 금액으로 나눴을 때의 나머지로 update
            quotientList.add(quotient);
        }

        return quotientList;
    }

}
