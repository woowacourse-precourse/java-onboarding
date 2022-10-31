package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
    가장 흔하게 접할 수 있는 유형의 문제중 하나입니다. 가장 큰 단위의 화폐를 최대 몇 개까지 사용할 수 있는지 확인한 후, 그 큰 단위의 화폐만큼의 돈을 원금에서 제외합니다.
    이런 과정을 가장 작은 단위의 화폐까지 계속하면 정답을 얻을 수 있습니다.
    */
    static int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            int dummy = (int)money / units[i];
            answer.add(dummy);
            money %= units[i];
        }

        return answer;
    }
}
