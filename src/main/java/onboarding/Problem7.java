package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends,
                                        List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Set<String> userFriends = new HashSet<>();
        Map<String, Integer> friendRelationScoreRepo = new HashMap<>();
        findUserFriends(user, friends, userFriends);
        calculateRelationScore(user, friends, userFriends, friendRelationScoreRepo);
        calculateVisitScore(userFriends, visitors, friendRelationScoreRepo);
        answer = getResult(friendRelationScoreRepo);
        return answer;
    }

    private static List<String> getResult(Map<String, Integer> friendRelationScoreRepo) {
        List<String> sortedResult = new ArrayList<>();
        List<Map.Entry<String, Integer>> entries =
            friendRelationScoreRepo.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                        @Override
                        public int compare(Map.Entry<String, Integer> o1,
                                           Map.Entry<String, Integer> o2) {
                            return o2.getValue() - o1.getValue();
                        }
                    })
                .collect(Collectors.toList());
        for (Map.Entry<String, Integer> entry : entries) {
            sortedResult.add(entry.getKey());
        }
        return sortedResult.stream().limit(5).collect(Collectors.toList());
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
