package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static Map<String, List<String>> getMembersFriendList(List<List<String>> friends) {
        Map<String, List<String>> memberFriendList = new HashMap<>();
        List<String> friendsList = new ArrayList<>();
        List<String> friendsList2 = new ArrayList<>();
        for(int i = 0; i < friends.size(); i++) {
            String member = friends.get(i).get(0);
            String member2 = friends.get(i).get(1);

            if (friendsList.isEmpty()) {
                friendsList.add(member2);
            } else if(!friendsList.contains(member2)) friendsList.add(member2);
            memberFriendList.put(member, friendsList);

            if (friendsList2.isEmpty()) {
                friendsList2.add(member);
            } else if(!friendsList2.contains(member)) friendsList2.add(member);
            memberFriendList.put(member2, friendsList2);
        }
        return memberFriendList;
    }
}
