package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // answer를 수정할 수 있게 새로운 인스턴스로 호출
        List<Integer> answer = new ArrayList<>();
        // 화폐 단위를 array형태로 저장
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        // 화폐 단위들을 나누는 수로 loop
        for (int i = 0; i < unit.length; i++){
            // 몫
            int q = money / unit[i];
            // 나머지를 다시 money로 선언
            money = money % unit[i];
            // 몫은 정답에 추가
            answer.add(q);
        }

        return answer;
    }
}
