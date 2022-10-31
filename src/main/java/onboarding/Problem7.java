package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    public static HashMap<String, List<String>> hpFriend = new HashMap<>();

    /**
     * 친구 관계 저장 메서드
     * @param friends 친구 관계 정보
     */
    public static void saveFriend(List<List<String>> friends) {
        for (List<String> o : friends) {
            List<String> friendList1 = hpFriend.getOrDefault(o.get(0), null);
            List<String> friendList2 = hpFriend.getOrDefault(o.get(1), null);

            if (friendList1 == null) {
                friendList1 = new ArrayList<>();
            }

            if (friendList2 == null) {
                friendList2 = new ArrayList<>();
            }

            friendList1.add(o.get(1));
            friendList2.add(o.get(0));
            hpFriend.put(o.get(0), friendList1);
            hpFriend.put(o.get(1), friendList2);

        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
