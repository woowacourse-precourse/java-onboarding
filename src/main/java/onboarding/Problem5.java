package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        /*
         * 각 화폐 단위로 나눠서 몫을 취하고 나머지가 있다면 다음 화폐 단위로 넘어가며 결과를 구한다.
         */
        List<Integer> answer = getNumOfBillsAndCoins(money);

        return answer;
    }

    public static List<Integer> getNumOfBillsAndCoins(int money) {
        List<Integer> ret = new ArrayList<>();

        int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; // 지폐 혹은 동전의 가짓수
        int cnt; // 지폐 혹은 동전의 개수를 담는 변수

        for (int item : moneyArr) {
            cnt = money / item;
            ret.add(cnt);
            money = money % item;
        }

        return ret;
    }
}
