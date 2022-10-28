package onboarding;
//1. 주어진 돈을 돈의 단위가 큰 것부터 나눈다.
//2. 주어진돈 - 돈의 단위 * 몫
//3. 나눈 몫으로 answer 값을 갱신한다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++)
            answer.add(0);
        int[] money_arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int cnt, idx;
        idx = 0;
        while (money > 0)
        {
            //1. 주어진 돈을 돈의 단위가 큰 것부터 나눈다.
            cnt = money / money_arr[idx];
            //2. 주어진돈 - 돈의 단위 * 몫
            money -= money_arr[idx] * cnt;
            //3. 나눈 몫으로 answer 값을 갱신한다.
            answer.set(idx, cnt);
            idx += 1;
        }
        return answer;
    }
}
