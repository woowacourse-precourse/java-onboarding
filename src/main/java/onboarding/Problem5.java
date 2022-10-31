package onboarding;

import java.util.ArrayList;
import java.util.List;

/* 기능 목록
 * 변환 가능한 화폐 개수를 반환해 주는 기능
 * 각 단위의 화폐에 대해 반복하여 업데이트하는 기능
 * */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] currencies = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

        for (int currency : currencies) {
            answer.add(change(money, currency));
            money %= currency;
        }

        return answer;
    }


    /**
     * 변환 가능한 화폐 개수를 반환합니다.
     *
     * @param money    변환할 돈
     * @param currency 화폐 단위
     * @return 변환 가능한 화폐 개수 반환
     */
    static int change(int money, int currency) {
        return money / currency;
    }
}
