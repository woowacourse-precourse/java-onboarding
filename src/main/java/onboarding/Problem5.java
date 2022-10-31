/**
 * 구현 요구 사항:
 * 돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
 * 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드 완성
 * <p>
 * 제한사항: money는 1 이상 1,000,000 이하인 자연수
 * <p>
 * 기능 목록:
 * 1. private static List<Integer> getSortedMoneyList(int money) 메서드: money를 큰 단위부터 반복해서 나누고 나눈 몫을 List에 저장해 반환하는 메서드
 */

package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = getSortedMoneyList(money);
        return answer;
    }

    private static List<Integer> getSortedMoneyList(int money) {
        int amountMoney = 0; // 현재 단위에서 빠질 수 있는 돈 단위의 개수를 저장
        int unit = 0; // 현재 돈의 단위를 저장
        List<Integer> unitList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1); // 돈의 단위들을 저장하는 List
        List<Integer> sortedMoneyList = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);

        for (int i = 0; i < unitList.size(); i++) {
            unit = unitList.get(i);
            amountMoney = money / unit;
            money -= amountMoney * unit;
            sortedMoneyList.set(i, amountMoney);
        }

        return sortedMoneyList;
    }

}
