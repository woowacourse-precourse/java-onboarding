package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> userScore = new HashMap<>();
        Map<String, List<String>> friendMap = createFriendMap(friends);

        // 친구 점수 주기
        for (String userFriend : friendMap.get(user)) {
            List<String> scoreTargets = friendMap.get(userFriend);
            plusFriendScore(userScore, scoreTargets);
        }
        // 방문자 점수 주기
        plusVisitorScore(visitors, userScore);
        return getSortedList(user, friendMap.get(user), getRecommendList(userScore));
    }

    private static void plusFriendScore(Map<String, Integer> userScore, List<String> scoreTargets) {
        for (String target : scoreTargets) {
            userScore.put(target, userScore.getOrDefault(target, 0) + 10);
        }
    }

    private static Map<String, List<String>> createFriendMap(List<List<String>> friends) {
        Map<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friendPair : friends) {
            makeFriends(friendMap, friendPair.get(0), friendPair.get(1));
            makeFriends(friendMap, friendPair.get(1), friendPair.get(0));
        }
        return friendMap;
    }

    public static void makeFriends(Map<String, List<String>> userFriends, String me, String friend) {
        List<String> friendList = userFriends.getOrDefault(me, Collections.emptyList());
        List<String> newFriendList = new ArrayList<>(friendList);
        newFriendList.add(friend);
        userFriends.put(me, newFriendList);
    }
    private static List<Map.Entry<String, Integer>> getRecommendList(Map<String, Integer> userScore) {
        List<Map.Entry<String, Integer>> entries = userScore.entrySet()
                .stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        Collections.reverse(entries);
        return entries;
    }

    private static void plusVisitorScore(List<String> visitors, Map<String, Integer> userScore) {
        visitors.forEach(
                visitor -> userScore.put(visitor, userScore.getOrDefault(visitor, 0) + 1)
        );
    }

    private static List<String> getSortedList(String user, List<String> userFriendList, List<Map.Entry<String, Integer>> recommendList) {
        List<String> answer = new ArrayList<>();
        int prevScore = 0;
        List<String> sameScoreList = new ArrayList<>();
        for (Map.Entry<String, Integer> userInfo : recommendList) {
            String username = userInfo.getKey();
            int score = userInfo.getValue();

            if (username.equals(user) || userFriendList.contains(username))
                continue;

            if (score <= 0 || answer.size() > 5)
                continue;

            if (prevScore == 0 || prevScore == score) {
                sameScoreList.add(username);
                prevScore = score;
                continue;
            }

            Collections.sort(sameScoreList);
            sameScoreList.add(username);
            answer.addAll(sameScoreList);
            sameScoreList.clear();
            prevScore = score;
        }
        return answer;
    }

}
