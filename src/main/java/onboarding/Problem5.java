package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] money_size = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 화폐 종류
        List<Integer> answer = new ArrayList<Integer>();
        int i = 0;  // 확인하고 있는 화폐 번호

        while (money > 0){  // 화폐를 맞출 때까지 확인
            int cnt = (int) (money / money_size[i]);    // 화폐가 몇 장 가능한지
            answer.add(cnt);
            money -= money_size[i++] * cnt; // 화폐 가격 정산
        }

        int tmp_size = answer.size();
        for (i=0; i<9 - tmp_size; i++){ // 추가 되지 않은 화폐 단위가 있다면 추가
            answer.add(0);
        }

        return answer;
    }
}
