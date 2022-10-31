package problem7;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private final String name;
    private final Map<String, Integer> recommendationScores = new HashMap<>();

    public User(String name) {
        this.name = name;
        preprocessRecommendationScores();
    }

    private void preprocessRecommendationScores() {
        recommendationScores.clear();

        var friends = FriendConnectionRepository.getFriends(name);

        FriendConnectionRepository.getUsers().stream()
                .filter(person -> !name.equals(person) && !friends.contains(person))
                .forEach(person -> recommendationScores.put(person, 0));
    }

    public List<String> getMostRecommendedAsFriend(List<String> visitors) {
        calculateRecommendationScoreWith(visitors);
        return calculateRecommendationScoreWithCommonFriends();
    }

    private void calculateRecommendationScoreWith(List<String> visitors) {
        visitors.stream()
                .filter(visitor -> recommendationScores.containsKey(visitor))
                .forEach(stranger ->
                        recommendationScores.put(stranger, recommendationScores.get(stranger) + 1));
    }

    public List<String> calculateRecommendationScoreWithCommonFriends() {
        var friends = FriendConnectionRepository.getFriends(name);

        if (friends.size() == 0) {
            // ,,
        }

        for (var friend : friends) {
            var hisFriends = FriendConnectionRepository.getFriends(friend);
            for (var hisFriendsFriend : hisFriends) {
                if (friends.contains(hisFriendsFriend) || name.equals(hisFriendsFriend)) {
                    continue;
                } else {
                    if (recommendationScores.containsKey(hisFriendsFriend)) {
                        recommendationScores.put(hisFriendsFriend
                                , recommendationScores.get(hisFriendsFriend) + 10);
                    } else {
                        recommendationScores.put(hisFriendsFriend
                                , 10);
                    }
                }
            }
        }

        // map을 entryset으로 변환한다.
        // 그걸 list로 변환한다.
        // list를 정렬한다.
        List<Map.Entry<String, Integer>> list = sortEntries();

        System.out.println(list);

        return list.stream()
                .map(e -> e.getKey())
                .limit(5)
                .collect(Collectors.toList());
    }

    private List<Map.Entry<String, Integer>> sortEntries() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(recommendationScores.entrySet());
        Collections.sort(list, (e1, e2) -> {
            if (e2.getValue() != e1.getValue()) return e2.getValue() - e1.getValue();
            return e1.getKey().compareTo(e2.getKey());
        });
        return list;
    }
}
