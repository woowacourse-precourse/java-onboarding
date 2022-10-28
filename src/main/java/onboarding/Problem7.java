package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        for (int i = 0; i < friends.size(); i++) {
            List friendsList = friends.get(i);
            for (int j = 0; j < friends.size(); j++) {
                if (j == i) {
                } else {
                    List otherFriendsList = friends.get(j);         // 기준 친구 리스트와 다른 친구리스트를 비교
                }
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
