package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     [기능목록]
     1. 화폐 단위로 이루어진 숫자 배열 만들기
     2. 큰 금액의 화폐 순서로 돈의 액수 나누어서 몫을 배열에 추가하기
     3. 나눈 나머지 값을 돈의 액수 값으로 변경하기
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 화폐 단위로 이루어진 숫자 배열 만들기
        int[] currency = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

        for(int num : currency) {
            // 큰 금액의 화폐 순서로 돈의 액수 나누어서 몫을 배열에 추가하기
            answer.add(money / num);
            // 나눈 나머지 값을 돈의 액수 값으로 변경하기
            money %= num;
        }

        return answer;
    }
}
