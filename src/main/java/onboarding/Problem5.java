package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = initResultList();
        return answer;
    }

    // 결과값을 저장할 배열을 초기화하는 함수
    public static ArrayList<Integer> initResultList() {
        ArrayList<Integer> temp = new ArrayList<Integer>(9);
        for (int i = 1; i <= 9; i++) {
            temp.add(0);
        }
        return temp;
    }
}
