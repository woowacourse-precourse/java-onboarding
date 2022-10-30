package onboarding;

import java.util.Collections;
import java.util.List;

final class MoneyInfo {

    int cnt;
    int change;

    public MoneyInfo(int cnt, int change) {
        this.cnt = cnt;
        this.change = change;
    }
}

public class Problem5 {

    public static List<Integer> solution(int money) {

        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    //돈을 지정된 금액의 화폐로 반환되는 개수와 반환하고 남은 돈의 액수 반환
    static MoneyInfo getCountMoney(int money, int unit) {

        int cnt = money / unit;
        int change = money % unit;

        return new MoneyInfo(cnt, change);
    }
}
