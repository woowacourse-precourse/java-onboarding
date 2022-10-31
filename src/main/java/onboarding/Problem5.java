package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    // 주어진 money(num)를 화폐단위(unit)으로 나눈 값과 해당 화폐단위로 money에서 최대한 뺀 잔액을 반환
    public static int[] count(int unit, int num){
        return new int[] {num - (num / unit * unit), num / unit};
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 화폐단위의 목록, 큰 금액 순서대로 탐색
        List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        for (int i = 0; i < units.size(); i++){
            int result[] = count(units.get(i), money);
            money = result[0];
            answer.add(result[1]);
        }
        return answer;
    }
}
