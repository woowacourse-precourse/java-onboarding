package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> divideByGrade(int money) {

        List<Integer> result = new ArrayList<>();
        int[] grade = {50000, 10000, 5000, 1000, 500 , 100, 50, 10, 1};

        for (int i = 0; i < grade.length;i++) {

            int cnt = 0;

            result.add(cnt);
            while (money / grade[i] != 0) {
                cnt++;              // 갯수 카운트
                result.set(i, cnt); // 갯수 갱신
                money -= grade[i];  // 변환된 금액 계산
            }

        }

        return result;

    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = divideByGrade(money);
        return answer;
    }

    public static void main(String[] args) {
        divideByGrade(5000);
    }
}
