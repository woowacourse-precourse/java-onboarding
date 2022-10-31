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

    public void preprocessRecommendationScores() {
        recommendationScores.clear();

        var friends = FriendConnectionRepository.getFriends(name);

        FriendConnectionRepository.getUsers().stream()
                .filter(person -> !name.equals(person) && !friends.contains(person))
                .forEach(person -> recommendationScores.put(person, 0));
    }

    public void calculateRecommendationScoreWith(List<String> visitors) {
        VisitorsValidator.validateVisitors(visitors);
        visitors.stream()
                .filter(visitor -> recommendationScores.containsKey(visitor))
                .forEach(stranger ->
                        recommendationScores.put(stranger, recommendationScores.get(stranger) + 1));
    }

    public List<String> calculateRecommendationScoreWithCommonFriends() {
        var friends = new HashSet<>(FriendConnectionRepository.getFriends(name));

        if (friends.size() == 0) {
            List<Map.Entry<String, Integer>> list = new ArrayList<>(recommendationScores.entrySet());
            Collections.sort(list, (e1, e2) -> {
                if (e2.getValue() != e1.getValue()) return e2.getValue() - e1.getValue();
                return e1.getKey().compareTo(e2.getKey());
            });
            return list.stream()
                    .map(e -> e.getKey())
                    .limit(5)
                    .collect(Collectors.toList());
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
        List<Map.Entry<String, Integer>> list = new ArrayList<>(recommendationScores.entrySet());
        Collections.sort(list, (e1, e2) -> {
            if (e2.getValue() != e1.getValue()) return e2.getValue() - e1.getValue();
            return e1.getKey().compareTo(e2.getKey());
        });

        System.out.println(list);

        return list.stream()
                .map(e -> e.getKey())
                .limit(5)
                .collect(Collectors.toList());

    }

    public static class VisitorsValidator {

        private static final int VISITORS_SIZE_LOWER_BOUNDS = 0;
        private static final int VISITORS_SIZE_UPPER_BOUNDS = 10_000;
        private static final String ERR_VISITORS_SIZE = "방문자는 0명 이상 10,000명 이하로 입력하세요.";

        public static void validateVisitors(List<String> visitors) {
            if (visitors.size() < VISITORS_SIZE_LOWER_BOUNDS || visitors.size() > VISITORS_SIZE_UPPER_BOUNDS)
                throw new IllegalArgumentException(ERR_VISITORS_SIZE);
        }
    }
}
