package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    /*
    1. 친구 관계를 전부 받은 후, 친구 목록 갱신
    2. 공통 친구 수*10만큼 점수 갱신
    3. 방문자 점수 갱신
    3. 점수-이름 순 정렬
     */

    static HashMap<String, List<String>> friendList;
    static HashMap<String, Integer> scoreBoard;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // user1의 친구로 user2를 추가하는 함수 addFriend()
    private static void addFriend(String user1, String user2) {
        if(!friendList.containsKey(user1)){
            friendList.put(user1, new ArrayList<>());
        }
        List<String> user1FriendList = friendList.get(user1);
        user1FriendList.add(user2);
        friendList.put(user1, user1FriendList);
    }

    // user1과 user2 사이의 공통 친구 수를 알아내는 함수 countCommonFriend()
    private static int countCommonFriend(String user1, String user2) {
        int cnt = 0;
        List<String> user1FriendList = friendList.get(user1);
        List<String> user2FriendList = friendList.get(user2);

        for (int i=0; i<user1FriendList.size(); i++){
            String user1Friend = user1FriendList.get(i);
            if(user2FriendList.contains(user1Friend)) {
                cnt++;
            }
        }
        return cnt;
    }

    // A에게 점수를 n만큼 추가해주는 함수

    // 사용자를 점수-이름 순으로 정렬해주는 함수 sortUserList()
}
