package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendList = new ArrayList<>();
        HashMap<String, Integer> memberList = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            friendList = insertFriendToListIfUserFriend(friends.get(i).get(0), friends.get(i).get(1), user, friendList);
            //전체 멤버 리스트 작성 기능
            memberList.put(friends.get(i).get(0), 0);
            memberList.put(friends.get(i).get(1), 0);
        }
        return answer;
    }
    //user의 친구목록을 작성하는 기능
    public static List<String> insertFriendToListIfUserFriend(String friend1, String friend2, String user, List<String>friendList){
        if (friend1.equals(user)) {
            friendList.add(friend2);
        }
        if (friend2.equals(user)) {
            friendList.add(friend1);
        }
        return friendList;
    }
}
