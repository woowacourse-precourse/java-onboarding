package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int mon[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 화폐 단위
        for (int i=0; i<mon.length; i++)
        {
            if(money >= mon[i]) // 화폐 단위보다 클 경우
            {
                answer.add(money/mon[i]); // 몫 만큼 answer에 추가
                money %= mon[i]; // 몫 * 화폐 단위 만큼 빼기
            }
            else answer.add(0); // 화폐 단위보다 작을 경우, answer에 0 추가
        }
        return answer;
    }
}
