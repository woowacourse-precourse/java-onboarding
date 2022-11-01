package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static final int SCORE_COMMON_FRIEND = 10;
    public static final int SCORE_VISIT = 1;
    public static List<String> solution(String targetUser, List<List<String>> friends, List<String> visitors) {
        // 친구 set 만들기
        Map<String, Set<String>> userToFriends = new HashMap<>(); // 타겟 유저 제외하고 전부 들어감
        Set<String> targetUserFriends = new HashSet<>();
        LinkedHashMap<String, Integer> notFriendToRecommendScore = new LinkedHashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friend1.equals(targetUser)) { // user 의 친구관계일 경우
                targetUserFriends.add(friend2);
            } else if (friend2.equals(targetUser)) {
                targetUserFriends.add(friend1);
            }
        }

        friends.stream().filter(f -> {
            String friend1 = f.get(0);
            String friend2 = f.get(1);
            return !friend1.equals(targetUser) && !friend2.equals(targetUser);
        }).forEach(f -> {
            String friend1 = f.get(0);
            String friend2 = f.get(1);

            if (!userToFriends.containsKey(friend1)) {
                // 유저의 친구목록을 초기화
                userToFriends.put(friend1, new HashSet<>());

                // 점수 해시맵 초기화
                if (!targetUserFriends.contains(friend1)) notFriendToRecommendScore.put(friend1, 0);
            }
            userToFriends.get(friend1).add(friend2);


            if (!userToFriends.containsKey(friend2)) {
                userToFriends.put(friend2, new HashSet<>());
                if (!targetUserFriends.contains(friend2)) notFriendToRecommendScore.put(friend2, 0);
            }
            userToFriends.get(friend2).add(friend1);
        });

        for (String friend : userToFriends.keySet()) {
            if (targetUserFriends.contains(friend)) {
                for (String user : userToFriends.get(friend)) {
                    Integer score = notFriendToRecommendScore.get(user);
                    if (score != null) notFriendToRecommendScore.put(user, score + SCORE_COMMON_FRIEND);
                }
            }
        }

        for (String visitor : visitors) {
            if (!targetUserFriends.contains(visitor)) { // 친구가 아니어야함
                Integer score = notFriendToRecommendScore.get(visitor);
                if (score == null) {
                    score = 0;
                }
                notFriendToRecommendScore.put(visitor, score + SCORE_VISIT);
            }
        }

        return notFriendToRecommendScore.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }
}
