package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1. user와 친구인 사람들(userFriends)을 가져오고
        // 2. usersFriends과 친구인 사람들의 점수를 정리
        // 3. visitors의 점수 정리

        HashMap<String, List<String>> userHashMap = new HashMap<>();

        List<String> friendsList = new ArrayList<>();
        userHashMap.put(user, friendsList);

        for(int i = 0; i < friends.size(); i++) {
            List<String> tempFriendsList = friends.get(i);
            if (tempFriendsList.contains(user)) {
                if (tempFriendsList.get(0).equals(user)) {
                    List<String> tempUserFriendsList = userHashMap.get(user);
                    tempUserFriendsList.add(tempFriendsList.get(1));
                    userHashMap.put(user, tempUserFriendsList);
                }
                else if(tempFriendsList.get(1).equals(user)) {
                    List<String> tempUserFriendsList = userHashMap.get(user);
                    tempUserFriendsList.add(tempFriendsList.get(0));
                    userHashMap.put(user, tempUserFriendsList);
                }
            }
        }

        return answer;
    }

}
