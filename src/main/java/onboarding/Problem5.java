package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    /**
     * 돈의 액수 money가 매개변수로 주어질 때
     * 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
     * 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하는 soultion method
     * 돈을 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 담는다.
     * @param money 출금 금액
     * @return 출금한 화폐 개수 리스트
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = exchangeMoney(money);
        return answer;
    }

    /**
     * 큰 금액의 화폐 위주로 출금 금액 환전
     * @param money 출금 금액
     * @return 환전한 화폐 갯수의 리스트
     */

    public static List<Integer> exchangeMoney(int money) {
        List<Integer> result = new ArrayList<>();
        int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int c : currency) {
            int num = (int) (money / c);
            result.add(num);
            money -= num * c;
        }
        return result;
    }
}