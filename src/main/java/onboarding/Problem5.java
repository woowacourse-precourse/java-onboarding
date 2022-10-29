package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /*
    * 주어진 돈이 주어진 단위 몇 개로 변환되는지 반환
    *
    * @return int
    * */
    private static int getCountByUnit(int money, int unit) {
        if (money < unit) {
            return 0;
        }

        return money / unit;
    }
}
