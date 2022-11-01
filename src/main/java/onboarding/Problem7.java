package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Problem7 {
/* 기능구현
1. 관계를 나타내는 맵 생성
2. 자신과 관계있는 친구들의 친구들을 맵에 등록한 후 +10 (단 내 친구들은 제외)
3. 자신을 방문했던 사람도 등록한 후  +1
4.  1순위 정렬 점수 내림차순
    (점수가 같다면) 이름 오름차순
* */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendMap = new HashMap<>();

        /* 친구 관계 맵 */
        for (List<String> friend : friends) {
            String p1 = friend.get(0);
            String p2 = friend.get(1);
            Set<String> p1Friends = friendMap.getOrDefault(p1, new HashSet<>());
            p1Friends.add(p2);
            friendMap.put(p1, p1Friends);
            Set<String> p2Friends = friendMap.getOrDefault(p2, new HashSet<>());
            p2Friends.add(p1);
            friendMap.put(p2, p2Friends);
        }

        Map<String, Integer> map = new HashMap<>();
        Set<String> friendsOfUser = friendMap.get(user);
        for (String s : friendMap.keySet()) {
            if (s.equals(user) || friendsOfUser.contains(s)) {
                continue;
            }
            Set<String> strings = friendMap.get(s);
            for (String string : friendsOfUser) {
                if (strings.contains(string)) {
                    map.put(s, map.getOrDefault(s, 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (friendMap.get(user).contains(visitor)) {
                continue;
            }
            map.put(visitor, map.getOrDefault(visitor, 0) + 1);
        }

        Map<Integer, List<String>> answer = new TreeMap<>(Comparator.reverseOrder());
        for (String s : map.keySet()) {
            List<String> list = answer.getOrDefault(map.get(s), new ArrayList<>());
            list.add(s);
            answer.put(map.get(s), new ArrayList<>(list));
        }

        List<String> ans = new ArrayList<>();
        for (int i : answer.keySet()) {
            List<String> list = answer.get(i);
            Collections.sort(list);
            ans.addAll(list);
        }

        return ans;
    }
}