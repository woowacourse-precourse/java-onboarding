package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends,
                                        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> userFriends = new HashSet<>();
        Map<String, Integer> friendRelationScoreRepo = new HashMap<>();
        findUserFriends(user, friends, userFriends);
        calculateRelationScore(user, friends, userFriends, friendRelationScoreRepo);
        calculateVisitScore(userFriends, visitors, friendRelationScoreRepo);
        return answer;
    }

    private static Map<String, Integer> calculateVisitScore(Set<String> userFriends,
                                                            List<String> visitors,
                                                            Map<String, Integer> friendRelationScoreRepo) {
        visitors.stream().forEach(visitor -> friendRelationScoreRepo.put(visitor,
            friendRelationScoreRepo.getOrDefault(visitor, 0) + 1));
        userFriends.stream().forEach(friendRelationScoreRepo::remove);
        return friendRelationScoreRepo;
    }

    private static Map<String, Integer> calculateRelationScore(
        String user, List<List<String>> friends, Set<String> userFriends,
        Map<String, Integer> friendRelationScoreRepo) {
        for (String userFriend : userFriends) {
            friends.stream().filter(friend -> friend.contains(userFriend))
                .forEach(friend -> friend.stream()
                    .filter(mate -> !Objects.equals(mate, userFriend))
                    .forEach(mate -> friendRelationScoreRepo.put(mate,
                        friendRelationScoreRepo.getOrDefault(mate, 0) + 10))
                );
        }
        friendRelationScoreRepo.remove(user);
        return friendRelationScoreRepo;
    }

    private static Set<String> findUserFriends(String user, List<List<String>> friends,
                                               Set<String> userFriends) {
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                userFriends.add(friend.get(0));
                userFriends.add(friend.get(1));
            }
        }
        userFriends.remove(user);
        return userFriends;
    }
}
