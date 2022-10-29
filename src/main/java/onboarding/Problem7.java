package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * > 요구사항
 * 1. 친구 관계 그래프 생성
 * 2. 사용자와 함께 아는 친구 수에 따른 점수 계산하기
 * 3. visitor 점수 계산하기
 * 4. 원래 User와 친구이거나 User는 결과에서 제외하기
 * 5. 정렬해서 출력
 */
public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {

        Set<String> friendSet = getFriendsList(friends, visitors);
        Map<String, List<String>> friendNetwork = makeGraph(friends);
        Set<String> alreadyUserFriendSet = findAlreadyFriends(user, friendNetwork);

        Map<String, Integer> scores = new HashMap<>();
        for (String friend : friendSet) {
            if (!friendNetwork.containsKey(friend)) {
                continue;
            }
            for (String adj : friendNetwork.get(friend)) {
                if (alreadyUserFriendSet.contains(adj)) {
                    scores.put(friend, scores.getOrDefault(friend, 0) + 10);
                }
            }
        }

        for (String friend : visitors) {
            scores.put(friend, scores.getOrDefault(friend, 0) + 1);
        }

        return scores.entrySet().stream()
            .sorted((o1, o2) -> o2.getValue() - o1.getValue())
            .limit(5)
            .map(Entry::getKey)
            .filter(s -> !alreadyUserFriendSet.contains(s) && !s.equals(user))
            .collect(Collectors.toList());
    }

    private static Map<String, List<String>> makeGraph(List<List<String>> friends) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> friend : friends) {
            String a = friend.get(0);
            String b = friend.get(1);
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        return graph;
    }

    private static Set<String> getFriendsList(List<List<String>> friends, List<String> visitors) {
        Set<String> answer = new HashSet<>();
        for (List<String> friendPair : friends) {
            answer.add(friendPair.get(0));
            answer.add(friendPair.get(1));
        }

        answer.addAll(visitors);
        return answer;
    }

    private static Set<String> findAlreadyFriends(String user,
        Map<String, List<String>> friendNetwork) {
        return new HashSet<>(friendNetwork.get(user));
    }

}
