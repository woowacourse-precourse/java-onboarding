package onboarding;

import java.util.*;

public class Problem7 {

    // 친구관계 Map
    public static HashMap<String, List<String>> friendMap;
    // 친구 관계 Map 생성
    public static void getFriendMap(List<List<String>> friends) {
        friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            // 왼쪽 친구 <- 오른쪽 친구 관계 생성
            friendMap.put(friend.get(0), addFriend(friend.get(0), friend.get(1)));
            // 오른쪽 친구 <- 왼쪽 친구 관계 생성
            friendMap.put(friend.get(1), addFriend(friend.get(1), friend.get(0)));
        }
    }

    // 친구리스트에 친구 추가
    public static List<String> addFriend(String leftFrined, String rightFriend) {
        List<String> list = new ArrayList<>();
        if (friendMap.get(leftFrined) != null) list = friendMap.get(leftFrined);
        list.add(rightFriend);

        return list;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
