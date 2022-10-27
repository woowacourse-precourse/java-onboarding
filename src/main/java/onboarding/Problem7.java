package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            friendList = insertFriendToListIfUserFriend(friends.get(i).get(0), user, friendList);
            friendList = insertFriendToListIfUserFriend(friends.get(i).get(1), user, friendList);
        }
        return answer;
    }
    //user의 친구목록을 작성하는 기능
    public static List<String> insertFriendToListIfUserFriend(String name, String user, List<String>friendList){
        if (name.equals(user)) {
            friendList.add(name);
        }
        return friendList;
    }
}
