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
        Map<String, Integer> relationMap = new HashMap<>();

        // user의 친구 목록 구하기
        friendSet.add(user);
        for(List<String> friendList : friends) {
            if(friendList.contains(user)) {
                friendSet.add(friendList.get(0));
                friendSet.add(friendList.get(1));
            }
        }
        friendSet.remove(user);

        // 사용자와 함께 아는 친구의 수 = 10점을 더해준다.
        for(String friend : friendSet) {
            for(List<String> friendList : friends) {
                String friendA = friendList.get(0);
                String friendB = friendList.get(1);
                String relation = "";

                //user의 친구 목록 friendSet에 존재하는 경우
                if(friendA.equals(friend)) {
                	relation = friendB;
                }     
                else if(friendB.equals(friend)) {
                	relation = friendA;
                }

                //user이거나 이름이 없을 경우 무시해준다.
                if(relation.equals(user) || relation.equals("")) {
                    continue;
                }

                //사용자와 함께 아는 사람 수 만금 10을 계속 터해준다.
                if(relationMap.containsKey(relation)) {
                	//이전에 10을 더한 경우 기존값에 10을 더한다.
                    relationMap.replace(relation, relationMap.get(relation) + 10);
                } 
                else {
                	//처음으로 사용자와 함께 아는 사람인 경우 10을 넣어준다.
                    relationMap.put(relation, 10);
                }
            }
        }

        // 사용자의 타임 라인에 방문한 횟수 = 1점를 더해준다.
        for(String visitor : visitors) {
            if(!friendSet.contains(visitor)) {
                if(relationMap.containsKey(visitor)) {
                	//이전에 방문했던 경우 기존값에 1을 던한다.
                    relationMap.replace(visitor, relationMap.get(visitor) + 1);
                } 
                else {
                	//처음 방문인 경우 1을 넣어준다.
                    relationMap.put(visitor, 1);
                }
            }
        }

        answer = new ArrayList<>(relationMap.keySet());
        //합계 점수를 기준으로 하여 친구 이름을 내림 차순 정렬
        Collections.sort(answer, (o1, o2) -> (relationMap.get(o2).compareTo(relationMap.get(o1))));

        //추천 점수가 0점이 아닌 사람 중 최대 5명만 return
        if(answer.size() > 5)
        	answer = answer.subList(0, 5);
        
        return answer;
    }
}
