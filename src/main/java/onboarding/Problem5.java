package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
     * 기능 정리 (★구현 정리로 바꿀 것)
     * 1. 화폐 금액 매핑 시키기
     * 2. 가장 큰 금액의 화폐부터 받아내어, 가장 적은 양으로 화폐를 받고 받은 화폐를 list에 저장.
     * */




    public static List<Integer> solution(int money) {
        List<Integer> answer = getLeastMoney(money);
        return answer;
    }
}
