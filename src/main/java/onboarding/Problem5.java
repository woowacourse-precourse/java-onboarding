package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
    // 50,000, 10,000, 5000, 1000, 500, 100, 50, 10, 1
    // 돈 변환 로직
    public static int[] transMoney(int money, int criteria){
        int count = money / criteria;
        int charge = money % criteria;
        return new int[]{count, charge};
    }
}
