package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 금액 받기 문제
 *
 * 문제 설명 :
 *  계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.
 *  돈의 액수 money가 매개변수로 주어질 때,
 *  오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지
 *  금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 *  - money는 1 이상 1,000,000 이하인 자연수이다.
 *
 * @author      scyllacore
 * @version     1.1 2022/10/31
 */

public class Problem5 {
    /*
     * 구현 사항
     * 1. moneyTable : 화폐 mapping 시키기.
     * 2. getLeastMoney : 가장 큰 금액의 화폐부터 받아내어 가장 적은 양으로 화폐를 받고, 받은 화폐 내역을 list에 저장.
     * 3. solution : 최종적으로 교환한 화폐 내역 반환.
     */

    /** 1. 문제 조건에 맞게 화폐를 mapping 시킨 배열. */
    static int moneyTable[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    /**
     * 2. 가장 큰 금액의 화폐부터 받을 수 있을 만큼 받고, 안될 시 다음 화폐로 이동하여 과정 반복.
     *    이렇게 하여 가장 적은 양으로 화폐를 받고, 받은 화폐 내역을 list에 저장.
     *
     * @param money 통장에 있는 금액.
     * @return 받은 화폐 내역.
     */
    static List<Integer> getLeastMoney(int money) {

        int remainedMoney = money;

        List<Integer> leastMoney = new ArrayList<Integer>(Collections.nCopies(moneyTable.length, 0));

        for (int i = 0; remainedMoney > 0; ) {
            if (remainedMoney >= moneyTable[i]) {
                leastMoney.set(i, leastMoney.get(i) + 1);
                remainedMoney -= moneyTable[i];
            } else {
                i++;
            }
        }

        return leastMoney;
    }

    /**
     * 3. 최종적으로 교환한 화폐 내역 반환.
     * 
     * @param money 통장에 있는 금액.
     * @return 최종 화폐 내역.
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = getLeastMoney(money);
        return answer;
    }
}
