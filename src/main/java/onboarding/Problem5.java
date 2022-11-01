package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [기능 목록]
 * 1. 화폐 단위별 개수 기능
 * - 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전별 개수
 * 2. 결과 출력 기능
 * - 금액이 큰 순서대로 리스트/배열에 담기
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        List<Integer> answer = new ArrayList<>();
        int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 1. 화폐 단위별 개수 기능
        for(int i = 0; i < cash.length; i++) {
            int a = money / cash[i]; // 각 지폐/동전 개수
            money %= cash[i]; // 나머지 값

            //2. 결과 출력 기능
            answer.add(a);
        }
        return answer;
    }
    /*
    public static void main(String[] args) { // TEST
        int money = 15000;

        solution(money);
    }

     */

}
