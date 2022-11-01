package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<Map.Entry<String, Integer>> entries = Collections.emptyList();
        Map<String, List<String>> eachFriends = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();

        initEachFriends(friends, eachFriends);

        addPointsVisitHistroy(user, visitors, eachFriends, scores);

        countSameFriendsPoints(user, eachFriends, scores);

        entries = sortByScoreAndName(scores);

        answer = getTop5Exclude0Points(entries);

        return answer;
    }

    private static void countSameFriendsPoints(String user, Map<String, List<String>> eachFriends, Map<String, Integer> scores) {
        // 함께 아는 친구의 수 반영: 각 10점
        // user의 친구 1명씩 꺼내기
        for (String friend : eachFriends.get(user)) {
            // 다른 친구들의 아는 친구목록 확인
            add10PointsEachSameFriend(user, eachFriends, scores, friend);
        }
    }

    private static List<String> getTop5Exclude0Points(List<Map.Entry<String, Integer>> entries) {
        // 결과 구하기
        List<String> recomentations = new ArrayList<>();
        int cnt = 0;

        for (Map.Entry<String, Integer> entry : entries) {
            if (++cnt > 5) break;

            recomentations.add(entry.getKey());
        }

        return recomentations;
    }

    private static List<Map.Entry<String, Integer>> sortByScoreAndName(Map<String, Integer> scores) {
        // 정렬
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(scores.entrySet());

        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return Integer.compare(o2.getValue(), o1.getValue());
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        return entries;
    }

    private static void addPointsVisitHistroy(String user, List<String> visitors, Map<String, List<String>> eachFriends, Map<String, Integer> scores) {
        // 타임라인 방문횟수 반영: 각 1점
        for (String visitor : visitors) {
            // 이미 친구인 사람은 추천할 필요가 없기에 제외
            if (isFriend(eachFriends, user, visitor)) continue;
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    private static void initEachFriends(List<List<String>> friends, Map<String, List<String>> eachFriends) {
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (!eachFriends.keySet().contains(friend1)) eachFriends.put(friend1, new ArrayList<>());
            if (!eachFriends.keySet().contains(friend2)) eachFriends.put(friend2, new ArrayList<>());

            eachFriends.get(friend1).add(friend2);
            eachFriends.get(friend2).add(friend1);
        }
    }

    private static void add10PointsEachSameFriend(String user, Map<String, List<String>> eachFriends, Map<String, Integer> scores, String friend) {
        for (String name : eachFriends.keySet()) {
            if (name.equals(user)) continue;

            if (isFriend(eachFriends, name, friend)) scores.put(name, scores.getOrDefault(name, 0) + 10);
        }
    }

    // 이름이 name인 사람의 친구중 friend가 있는가
    private static boolean isFriend(Map<String, List<String>> eachFriends, String name, String friend) {
        return eachFriends.get(name).contains(friend);
    }
}
