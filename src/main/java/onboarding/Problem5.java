package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /**
     * 화폐 단위
     */
    public static int[] pay = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    /**
     * 화폐 교환 메서드
     * @param money 변환할 돈의 액수
     * @param much 화폐 단위
     * @return 해당 액수에서 최대로 거슬러 줄 수 있는 화폐 수
     */
    public static int changeMoney(int money, int much) {
        int cnt = 0;
        if (money >= much) {
            cnt += (money / much);
        }
        return cnt;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int much : pay) {
            answer.add(changeMoney(money, much));
            money = (money % much);
        }
        return answer;
    }
}
