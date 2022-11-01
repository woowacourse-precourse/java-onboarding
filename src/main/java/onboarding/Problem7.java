package onboarding;

import custom.problem7.Network;
import custom.problem7.ScoreResolver;
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

        Network friendsNetwork = new Network(friends);
        ScoreResolver scoreResolver = new ScoreResolver(friendsNetwork, visitors);

        Set<String> friendSet = getFriendSet(friends, visitors);
        Map<String, Integer> scoreResult = new HashMap<>();

        for (String friend : friendSet) {
            if (friendsNetwork.getAdj(user).contains(friend) || friend.equals(user)) {
                continue;
            }
            scoreResult.put(friend, scoreResolver.calculateTargetUserScore(user, friend));
        }

        return scoreResult.entrySet().stream()
            .filter(entry -> entry.getValue() > 0)
            .sorted((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            })
            .map(Entry::getKey).limit(5)
            .collect(Collectors.toList());
    }

    private static Set<String> getFriendSet(List<List<String>> friends, List<String> visitors) {
        Set<String> set = new HashSet<>();
        friends.forEach(set::addAll);
        set.addAll(visitors);
        return set;
    }
}
