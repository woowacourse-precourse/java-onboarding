package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 구현순서
 * 1. 유저의 친구를 찾는다.findFriend() 메소드 작성
 * 2. 유저의 친구의 친구를 찾는다. (리스트 형식)
 * 3. 유저의 친구의 친구 리스트에서 유저의 친구를 제외한다.
 * 4. key(name), value(score)를 갖는 Map으로 친구 점수를 매긴다.
 * 5. 위의 Map의 key, value를 역전시켜 TreeMap에 대입한다.
 * 6. TreeMap에서 순차적으로 user를 answer에 최대 5명까지 add한다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        // find user friend
        List<List<String>> friendsTmp = new ArrayList<>(friends);
        List<String> visitorsTmp = new ArrayList<>(visitors);
        Set<String> userFriend = findFriend(friendsTmp, user);

        // find user friend friend
        List<String> uff = new ArrayList<>();
        for (String uf : userFriend) {
            uff.addAll(findFriend(friendsTmp, uf));
        }
        uff.removeAll(userFriend);

        Map<String, Integer> scoreMap = new HashMap<>();

        // calc friend score
        for (String name : uff) {
            scoreMap.put(name, scoreMap.getOrDefault(name, 0) + 10);
        }

        // calc visit score
        visitorsTmp.removeAll(userFriend);
        for (String name : visitorsTmp) {
            scoreMap.put(name, scoreMap.getOrDefault(name, 0) + 1);
        }

        // reverse map
        List<Integer> scores = scoreMap.values().stream()
                .distinct()
                .collect(Collectors.toList());

        Map<Integer, List<String>> scoreMapReverse = new TreeMap<>(Collections.reverseOrder());
        for (Integer score : scores) {
            for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
                if (entry.getValue().equals(score)) {
                    scoreMapReverse.putIfAbsent(score, new ArrayList<>());
                    scoreMapReverse.get(score).add(entry.getKey());
                }
            }
        }

        List<String> answer = new ArrayList<>();
        int cnt = 0;
        for (Map.Entry<Integer, List<String>> map : scoreMapReverse.entrySet()) {
            Collections.sort(map.getValue());
            for (String name : map.getValue()) {
                answer.add(name);
                cnt++;
                if (cnt == 5)
                    return answer;
            }
        }

        return answer;
    }

    /**
     * friends list에서 user의 친구를 찾아준다.
     * 
     * @param friends
     * @param user
     * @return user의 친구를 List 형식으로 반환한다.
     */
    private static Set<String> findFriend(List<List<String>> friends, String user) {
        Set<String> userFriend = new HashSet<>();
        for (int i = 0; i < friends.size(); i++) {
            int userIndex = friends.get(i).indexOf(user);
            // if contain user, then add to user friend list and remove element
            if (userIndex >= 0) {
                int friendIndex = userIndex == 0 ? 1 : 0;
                userFriend.add(friends.get(i).get(friendIndex));
                friends.remove(i);
                i--;
            }
        }
        return userFriend;
    }

}
