package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static class MoneyInfo {

        int cnt;
        int change;

        public MoneyInfo(int cnt, int change) {
            this.cnt = cnt;
            this.change = change;
        }
    }

    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        MoneyInfo countMoney;

        for (int unit : units) {
            countMoney = getCountMoney(money, unit);
            answer.add(countMoney.cnt);
            money = countMoney.change;
        }

        return answer;
    }

    //돈을 지정된 금액의 화폐로 반환되는 개수와 반환하고 남은 돈의 액수 반환
    static MoneyInfo getCountMoney(int money, int unit) {

        int cnt = money / unit;
        int change = money % unit;

        return new MoneyInfo(cnt, change);
    }
}
