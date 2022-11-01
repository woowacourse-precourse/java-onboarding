package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
	
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	
    	List<String> answer;
        Set<String> friendSet = new HashSet<>();
        Map<String, Integer> neighborMap = new HashMap<>();

        // user의 친구 목록 구하기
        friendSet.add(user);
        for(List<String> friendList : friends) {
            if(friendList.contains(user)) {
                friendSet.add(friendList.get(0));
                friendSet.add(friendList.get(1));
            }
        }
        friendSet.remove(user);

        // 추천 점수 계산
        for(String friend : friendSet) {
            for(List<String> friendList : friends) {
                String a = friendList.get(0);
                String b = friendList.get(1);
                String neighbor = "";

                if(a.equals(friend)) {
                    neighbor = b;
                } else if(b.equals(friend)) {
                    neighbor = a;
                }

                if(neighbor.equals(user) || neighbor.equals("")) {
                    continue;
                }

                if(neighborMap.containsKey(neighbor)) {
                    neighborMap.replace(neighbor, neighborMap.get(neighbor) + 10);
                } else {
                    neighborMap.put(neighbor, 10);
                }
            }
        }

        // 방문 점수 계산
        for(String visitor : visitors) {
            if(!friendSet.contains(visitor)) {
                if(neighborMap.containsKey(visitor)) {
                    neighborMap.replace(visitor, neighborMap.get(visitor) + 1);
                } else {
                    neighborMap.put(visitor, 1);
                }
            }
        }

        // 점수 기준 내림차순 정렬
        answer = new ArrayList<>(neighborMap.keySet());
        Collections.sort(answer, (o1, o2) -> (neighborMap.get(o2).compareTo(neighborMap.get(o1))));

        return answer;
    }
}
