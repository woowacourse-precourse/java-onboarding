package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static HashMap<String, List<String>> makeFriendshipMap(List<List<String>> friends) {
        HashMap<String, List<String>> friendship = new HashMap<>();

        for (List<String> relation : friends) {
            String one = relation.get(0);
            String other = relation.get(1);

            List<String> oneFriends = friendship.getOrDefault(one, new ArrayList<>());
            List<String> otherFriends = friendship.getOrDefault(other, new ArrayList<>());

            oneFriends.add(other);
            otherFriends.add(one);

            friendship.put(one, oneFriends);
            friendship.put(other, otherFriends);
        }

        return friendship;
    }
}
