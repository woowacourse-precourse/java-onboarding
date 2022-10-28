package onboarding;

import java.util.Collections;
import java.util.List;

/**
 * 기능 :
 *  1. money가 주어 질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원동전, 일원 동전 각각 몇개로 변환되는지
 *    금액이 큰 순서대로 리스트/배열에 담아 return
 * 제한 사항 :
 *  1. money는 1 이상 1,000,000 이하인 자연수
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        return restrictions(money)
                ? Collections.emptyList()
                : Collections.emptyList();
    }

    private static boolean restrictions(int money) {
        return money < 1 || money > 1_000_000;
    }
}
