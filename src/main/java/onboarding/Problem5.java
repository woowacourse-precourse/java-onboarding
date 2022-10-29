package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 🚀 기능 요구 사항
 * 계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.
 *
 * 돈의 액수 money가 매개변수로 주어질 때,
 * 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
 * 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 * money는 1 이상 1,000,000 이하인 자연수이다.
 */

public class Problem5 {
    private static final int[] WON = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> currencyCount = IntStream.of(new int[WON.length])
                .boxed()
                .collect(Collectors.toList());
        countMoney(money, currencyCount);
        return currencyCount;
    }

    private static void countMoney(int money, List<Integer> currencyCount) {
        int currentMoney = money;
        for (int i = 0; i < WON.length; i++) {
            if (currentMoney >= WON[i]) {
                currencyCount.set(i, currentMoney / WON[i]);
                currentMoney %= WON[i];
            }
        }
    }
}
