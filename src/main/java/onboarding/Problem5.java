package onboarding;

import java.util.Collections;
import java.util.List;

/* 기능 목록
 * 변환 가능한 화폐 개수를 반환해 주는 기능
 * 각 단위의 화폐에 대해 반복하여 업데이트하는 기능
 * */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }


    /**
     * 변환 가능한 화폐 개수를 반환합니다.
     *
     * @param money    변환할 돈
     * @param currency 화폐 단위
     * @return 변환 가능한 화폐 개수 반환
     */
    int change(int money, int currency) {
        return money / currency;
    }
}
