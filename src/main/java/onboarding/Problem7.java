package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> friendList = new HashSet<>();
        HashMap<String, Integer> suggestScoreList = new HashMap<>();
        List<List<String>> notFriendList = new ArrayList<>();

        friends.forEach((relationship) -> {
            String person1 = relationship.get(0);
            String person2 = relationship.get(1);

            if (Objects.equals(person1, user)) {
                friendList.add(person2);
            } else if (Objects.equals(person2, user)) {
                friendList.add(person1);
            } else {
                notFriendList.add(relationship);
            }
        });

        System.out.println(friendList);
        System.out.println(suggestScoreList);
        System.out.println(notFriendList);

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
