package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> score = new HashMap<>();
        chk_user_friend(user, friends, score);

        return answer;
    }
    /**사용자와 이미 친구인 크루의 점수를 최소값으로 초기화**/
    private static void chk_user_friend(String user, List<List<String>> friends, HashMap<String, Integer> score) {
        /*사용자와 이미 친구인 경우는 제외하여야 한다*/
        for (int i = 0; i < friends.size(); i++) {
            List<String> relation= friends.get(i);
            for (int j = 0; j < 2; j++) {
                String currName=relation.get(j);
                if (currName.equals(user)) {            // 이미 친구인 경우를 처리
                    if (j == 0) {
                        score.putIfAbsent(relation.get(1), Integer.MIN_VALUE);
                    } else {
                        score.putIfAbsent(relation.get(0), Integer.MIN_VALUE);
                    }
                }
            }
        }
    }
}
