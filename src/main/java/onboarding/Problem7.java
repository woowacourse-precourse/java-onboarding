package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    /**
     * 기능 목록 작성
     * 1. 유저의 친구를 찾는 기능
     * 2. 유저의 친구의 친구를 찾는 기능
     * 3. 친구의 친구 점수와 방문자의 점수를 합해서 가지고있는 기능
     * 4. 점수를 비교해 상위 5명만 반환하는 기능
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            }
            if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        List<String> friendOfFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user) || friend.get(1).equals(user)) {
                continue;
            }
            if (userFriends.contains(friend.get(0))) {
                friendOfFriends.add(friend.get(1));
            }
            if (userFriends.contains(friend.get(1))) {
                friendOfFriends.add(friend.get(0));
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
