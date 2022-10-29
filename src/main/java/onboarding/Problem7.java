package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> userToFriends = parseFriends(friends);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    static List<String> findAllUserWithoutMainCharacter(String mainCharacter, Map<String, List<String>> userToFriends, List<String> visitors) {
        List<String> allUserWithoutMainCharacter = new ArrayList<>();

        userToFriends.forEach((user, friends) -> allUserWithoutMainCharacter.add(user));
        visitors.forEach(visitor -> allUserWithoutMainCharacter.add(visitor));
        return allUserWithoutMainCharacter.stream()
            .filter(user -> !user.equals(mainCharacter))
            .distinct()
            .collect(Collectors.toList());
    }

    static List<String> exceptAlreadyFriends(String user, List<String> allFriends, Map<String, List<String>> userToFriends) {
        return null;
    }

    static Map<String, List<String>> parseFriends(List<List<String>> friends) {
        Map<String, List<String>> parsedFriends = new HashMap<>();

        friends.forEach(user -> {
            String user1 = user.get(0);
            String user2 = user.get(1);

            addFriend(parsedFriends, user1, user2);
            addFriend(parsedFriends, user2, user1);
        });

        return parsedFriends;
    }

    private static void addFriend(Map<String, List<String>> parsedFriends, String user1, String user2) {
        if (!parsedFriends.containsKey(user1)) {
            parsedFriends.put(user1, new ArrayList<>());
        }
        List<String> userFriends = parsedFriends.get(user1);
        userFriends.add(user2);
        parsedFriends.put(user1, userFriends);
    }

}
