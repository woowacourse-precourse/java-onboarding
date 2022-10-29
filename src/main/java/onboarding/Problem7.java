package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    public static HashMap<String, HashSet<String>> friendListInfo;
    public static void setFriendList(List<List<String>> friends) {
        for(int index = 0; index < friends.size(); index ++) {
            String person1 = friends.get(index).get(0);
            String person2 = friends.get(index).get(1);

            HashSet<String> person1FriendList = friendListInfo.get(person1);
            HashSet<String> person2FriendList = friendListInfo.get(person2);

            person1FriendList.add(person2);
            person2FriendList.add(person1);

            friendListInfo.put(person1,person1FriendList);
            friendListInfo.put(person2,person2FriendList);
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
