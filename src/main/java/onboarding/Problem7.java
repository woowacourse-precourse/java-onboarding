package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    /**
     * 사용자와 친구인 사람을 구하는 메서드
     *
     * @param user 사용자 아이디
     * @param friends 친구 관계 정보
     * @return 사용자와 친구인 리스트
     */
    public List<String> createUserFriendsList(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> friendList = friends.get(i);

            if (friendList.get(0) == user) {
                list.add(friendList.get(1));
            } else if (friendList.get(1) == user) {
                list.add(friendList.get(0));
            }
        }

        return list;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
