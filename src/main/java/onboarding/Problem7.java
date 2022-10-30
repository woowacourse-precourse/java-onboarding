package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {

    private static Map<String, Set<String>> friendsList = new HashMap<>();
    private static Map<String, Integer> usersScore = new HashMap<>();
    
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 친구 테이블 구성
        for (List<String> friend : friends) {
            String A = friend.get(0);
            String B = friend.get(1);
            updateFriendsList(A, B);
            updateFriendsList(B, A);
        }
        Set<String> userFreindList = friendsList.get(user);

        //  함께 아는 친구의 수 계산
        for (String name : friendsList.keySet()) {
            if (userFreindList.contains(name) || name.equals(user)) // user와 이미 친구인 경우 패스
                continue;

            Set<String> eachFriendList = friendsList.get(name);
            eachFriendList.retainAll(userFreindList); // user와 함께 아는 친구
            int acquaintanceNum = eachFriendList.size();
            usersScore.put(name, acquaintanceNum * 10);
        }

        return answer;
    }

    static void updateFriendsList(String A, String B) {
        if (friendsList.containsKey(A)) {
            friendsList.get(A).add(B);
        } else {
            Set<String> newFriendList = new HashSet<>();
            newFriendList.add(B);
            friendsList.put(A, newFriendList);
        }
    }
}
