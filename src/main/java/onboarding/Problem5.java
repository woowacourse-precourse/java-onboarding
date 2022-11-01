package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 화폐 단위로 money를 나눠야하기 때문에 따로 배열로 준비해준다.
        int coin[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // answer에 담길 화폐의 개수
        int count = 0;
        // 화폐 단위를 변화시켜줄(coin배열에서 사용될) index 번호
        int idx = 0;

        while (money > 0){
            count = money / coin[idx];
            answer.add(count);

            // 사용한 지폐 만큼 값 빼주기
            money %= coin[idx];
            idx += 1;
        }

        // 1원까지 가기 전에 이미 0원이 됐을 때,
        // 나머지 화폐 사용에 0을 담아 주기 위해서 for문을 사용해준다.
        if (idx < coin.length){
            for (int i = 0; i < coin.length - idx; i++) {
                answer.add(0);
            }
        }

        return answer;
    }
}
