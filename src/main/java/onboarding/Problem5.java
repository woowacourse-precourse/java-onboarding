package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyUnits = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = changeCash(money);
        return answer;
    }

    private static List<Integer> changeCash(int money) {
        List<Integer> changeCashes = new ArrayList<>();
        for (Integer moneyUnit : moneyUnits) {
            changeCashes.add(money / moneyUnit);
            money %= moneyUnit;
        }
        return changeCashes;
    }
}
/*
문제 설명
  1. 계좌에 들어있는 돈 일부를 은행에서 출금함
  2. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받음
  3. money가 주어지면 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원 동전 각 몇개로 변환되는지 금액이 큰 순서로 리스트/배열에 담아 리턴

문제 예시
  1. 50237 => [1, 0, 0, 0, 0, 2, 0, 3, 7]
  2. 15000 => [0, 1, 1, 0, 0, 0, 0, 0, 0]

제한사항 및 주의할점
  - money 는 1이상 1,000,000 이하인 자연수
 */