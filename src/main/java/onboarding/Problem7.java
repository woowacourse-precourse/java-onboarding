package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        /*
        1. 친구의 친구 아이디 추가, 점수 + 10
        2. 방문자 아이디 추가, 점수 + 1
        3. 만약 이미 아이디 있으면 점수만 추가
        4. user, friends[][0]에 있는 아이디의 점수 0으로 만들기
        5. 점수 높은 순으로 출력, 점수 0인 경우는 출력 안 함
         */
        List<String> answer = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            name.add(friends.get(i).get(1));
            score.add(10);
        }

        return answer;
    }
}
