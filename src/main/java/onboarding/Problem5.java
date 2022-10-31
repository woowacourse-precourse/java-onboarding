package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem5 {

    public static int[] wallet = new int[]{ 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    /**
     *
     * @param money
     * @param list
     * 액수와 list를 넘겨받고, 계산을 담당하는 함수
     */
    public static void calculate(int money, List<Integer> list) {

        for (int i = 0; i < 9; i++) {
            int current = 0;
            // 현재 액수를 뺄 수 있을 만큼 빼면서, 돈의 개수를 증가
            while (money >= wallet[i]) {
                money -= wallet[i];
                current++;
            }
            list.add(current);
        }

    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        calculate(money, answer);
        return answer;
    }
}
