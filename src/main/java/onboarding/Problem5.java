package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     * Goal: 돈의 액수 money가 매개변수로 주어질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
     * 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return
     * How:
     *     1. 큰 금액 순으로 나눈다
     *     2. Remainder를 그 다음 큰 화폐로 나눈다
     *     3. 1 과 2를 일원 동전으로 나웠을때까지 반복한다
     * @param money 변환해야할 금액
     * @return money를 최소의 화폐로 나누고 쓰인 화폐의 숫자를 큰 순서대로 담은 리스트
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> billSize = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        int remainder = money;
        int afterDivision = 0;

        for (int bill:billSize) {
            afterDivision = remainder / bill;
            remainder = remainder % bill;
            answer.add(afterDivision);
        }

        return answer;
    }
}
