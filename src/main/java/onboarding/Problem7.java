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
    static List<String> createUserFriendsList(String user, List<List<String>> friends) {
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

    /**
     * 사용자의 친구 리스트에서 찾고자 하는 사람이 있는지 확인하는 메서드
     * 
     * @param name 확인하는 사람
     * @param friendsList 친구 리스트
     * @return 친구 리스트에 있으면 true, 아니라면 false
     */
    static boolean isFriend(String name, List<String> friendsList) {
        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i) == name) {
                return true;
            }
        }

        return false;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
