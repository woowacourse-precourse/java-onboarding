package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> contacts = new HashMap<>();
        for (List<String> friend : friends) { // 친구 목록 만들기
            String peopleA = friend.get(0);
            String peopleB = friend.get(1);

            contacts.put(peopleA, makeFriendList(peopleB, contacts.get(peopleA)));
            contacts.put(peopleB, makeFriendList(peopleA, contacts.get(peopleB)));
        }


        return answer;
    }

    private static List<String> makeFriendList(String people, List<String> friendList) {
        if (friendList==null) {
            return new ArrayList(Arrays.asList(people));
        }
        friendList.add(people);
        return friendList;
    }

    private static boolean isFriends(String name, List<String> friendList) {
        return friendList.contains(name);
    }
}
