package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) { // 50000원 부터 나누어서 가장 작은 단위까지 몫을 구하자
        List<Integer> answer = new ArrayList<Integer>(9);
        int temp = money;
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i : arr) {
        	answer.add((int) money / i);
        	temp = temp % i;
        }
        return answer;
    }
}
