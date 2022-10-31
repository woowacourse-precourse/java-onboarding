package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.nCopies(9, 0));

        List<Integer> moneylist = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));//돈 종류
        while (money != 0) {
            for (int i = 0; i < moneylist.size(); i++) {
                int count = money / moneylist.get(i); //해당 종류의 돈으로 받을수 있는 최대 개수
                if (count > 0) { //받을 수 있는 경우
                    answer.set(i, count); //몇개 받을 수 있는지 기록
                    money %= moneylist.get(i); //받은 만큼 전체 돈에서 제외
                }
            }
        }
        return answer;
    }
}
