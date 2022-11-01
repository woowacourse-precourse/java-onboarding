package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scores = new HashMap<>(); // 추천 점수 목록

        List<String> closeFriends = findCloseFriends(user, friends);
        List<String> distantFriends = findDistantFriends(user, closeFriends, friends);

        addDistantFriendScore(scores, distantFriends);
        addVisitorScore(scores, visitors);

        excludeCloseFriends(scores, closeFriends);

        Map<String, Integer> sortedScore = sortScore(scores);

        return getRecommendedFriends(sortedScore);
    }

    /**
     * 최대 5명의 친구 추천 목록을 반환한다.
     */
    private static List<String> getRecommendedFriends(Map<String, Integer> sortedScore) {
        List<String> recommendedFriends = new ArrayList<>();

        for (String friend : sortedScore.keySet()) {
            recommendedFriends.add(friend);

            if (recommendedFriends.size() == 5) {
                break;
            }
        }

        return recommendedFriends;
    }

    /**
     * Map을 Value(추천 점수)를 기준으로 내림차순 정렬하고,
     * Value(추천 점수)가 같다면 key(이름)를 기준으로 오름차순 정렬한다.
     */
    private static LinkedHashMap<String, Integer> sortScore(Map<String, Integer> map) {
        LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());

        // value(점수) 내림차순으로 정렬하고, value(점수)가 같으면 key(이름) 사전 순으로 정렬
        Collections.sort(entries, (o1, o2) -> {
            int compare = o2.getValue().compareTo(o1.getValue());
            return compare == 0 ? o1.getKey().compareTo(o2.getKey()) : compare;
        });

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    /**
     * 가까운 친구를 추천 점수 목록에서 제외시킨다.
     */
    private static void excludeCloseFriends(Map<String, Integer> scores, List<String> closeFriends) {
        for (String userFriend : closeFriends) {
            scores.remove(userFriend);
        }
    }

    /**
     * 사용자의 타임 라인에 방문한 친구에게 추천 점수를 부여한다.
     */
    private static void addVisitorScore(Map<String, Integer> scores, List<String> visitors) {
        for (String visitor : visitors) {
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    /**
     * 사용자의 먼 친구(함께 아는 친구)에게 추천 점수를 부여한다.
     */
    private static void addDistantFriendScore(Map<String, Integer> scores, List<String> distantFriends) {
        for (String friend : distantFriends) {
            scores.put(friend, scores.getOrDefault(friend, 0) + 10);
        }
    }

    /**
     * 사용자와 먼 친구(함께 아는 친구) 목록을 반환한다.
     */
    private static List<String> findDistantFriends(String user, List<String> closeFriends, List<List<String>> friends) {
        List<String> distantFriends = new ArrayList<>();

        for (String closeFriend : closeFriends) {
            distantFriends = findCloseFriends(closeFriend, friends);
            distantFriends.remove(user);
        }

        return distantFriends;
    }

    /**
     * 사용자와 가까운 친구 목록을 반환한다.
     */
    private static List<String> findCloseFriends(String user, List<List<String>> friends) {
        List<String> closeFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String name : friend) {
                    if (!name.equals(user)) {
                        closeFriends.add(name);
                    }
                }
            }
        }

        return closeFriends;
    }
}
