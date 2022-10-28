package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    // 리스트 0 으로 초기화
    private static List<Integer> initList(List<Integer> list) {
        list = new ArrayList<>();
        for(int i = 0; i<9; i++) {
            list.add(0);
        }
        return list;
    }
}
