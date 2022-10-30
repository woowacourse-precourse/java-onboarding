package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        // 화폐 목록을 담는 List 생성 (금액이 큰 순서대로 저장)
        // 화폐 목록 : 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전

        // 금액이 큰 순서대로 money가 각각의 화폐 몇개씩으로 변환되는지 저장하는 List 생성 (quotientList)

        // 화폐 목록에 저장되어 있는 값에 대하여 순서대로 아래의 과정을 진행
        // 1. money를 금액으로 나눴을 때 몫이 1 이상이라면
        // -> 몫을 quotientList에 저장, money는 money를 금액으로 나눴을 때의 나머지로 갱신
        // 2. money를 금액으로 나눴을 때 몫이 0이라면
        // -> quotientList에 0을 저장

        // 화폐 목록에 저장되어 있는 값을 전부 다 보았다면 answer = quotientList

        return answer;
    }

}
