package problem7;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private static final int VISITORS_SIZE_LOWER_BOUNDS = 0;
    private static final int VISITORS_SIZE_UPPER_BOUNDS = 10_000;
    private static final String ERR_VISITORS_SIZE = "방문자는 0명 이상 10,000명 이하로 입력하세요.";

    private final Map<String, Integer> strangerToRecommendationScore = new HashMap<>();
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public static void validateVisitors(List<String> visitors) {
        if (visitors.size() < VISITORS_SIZE_LOWER_BOUNDS || visitors.size() > VISITORS_SIZE_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_VISITORS_SIZE);
    }

    public void calculateRecommendationScoreWith(List<String> visitors) {
        validateVisitors(visitors);

        var friends = FriendConnectionRepository.getFriends(name);

        visitors.stream()
                .filter(visitor -> !friends.contains(visitor) && !visitor.equals(name))
                .filter(stranger -> !strangerToRecommendationScore.containsKey(stranger))
                .forEach(newStranger -> strangerToRecommendationScore.put(newStranger, 0));

        visitors.stream()
                .filter(visitor -> !friends.contains(visitor) && !visitor.equals(name))
                .filter(stranger -> strangerToRecommendationScore.containsKey(stranger))
                .forEach(existingStranger -> strangerToRecommendationScore.put(existingStranger
                        , strangerToRecommendationScore.get(existingStranger) + 1));

    }

    public List<String> calculateRecommendationScoreWithCommonFriends() {
        var friends = new HashSet<>(FriendConnectionRepository.getFriends(name));

        for (var friend : friends) {
            var hisFriends = FriendConnectionRepository.getFriends(friend);
            for (var hisFriendsFriend : hisFriends) {
                if (friends.contains(hisFriendsFriend) || name.equals(hisFriendsFriend)) {
                    continue;
                } else {
                    if (strangerToRecommendationScore.containsKey(hisFriendsFriend)) {
                        strangerToRecommendationScore.put(hisFriendsFriend
                                , strangerToRecommendationScore.get(hisFriendsFriend) + 10);
                    } else {
                        strangerToRecommendationScore.put(hisFriendsFriend
                                , 10);
                    }
                }
            }
        }

        // map을 entryset으로 변환한다.
        // 그걸 list로 변환한다.
        // list를 정렬한다.
        List<Map.Entry<String, Integer>> list = new ArrayList<>(strangerToRecommendationScore.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        System.out.println(list);

        return list.stream()
                .map(e -> e.getKey())
                .limit(5)
                .collect(Collectors.toList());

    }
}
