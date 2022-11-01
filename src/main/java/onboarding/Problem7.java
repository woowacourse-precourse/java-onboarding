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

        friendSet.add(user);
        for(List<String> friendList : friends) {
            if(friendList.contains(user)) {
                friendSet.add(friendList.get(0));
                friendSet.add(friendList.get(1));
            }
        }
        friendSet.remove(user);

        for(String friend : friendSet) {
            for(List<String> friendList : friends) {
                String friendA = friendList.get(0);
                String friendB = friendList.get(1);
                String relation = "";

                if(friendA.equals(friend)) {
                	relation = friendB;
                }     
                else if(friendB.equals(friend)) {
                	relation = friendA;
                }

                if(relation.equals(user) || relation.equals("")) {
                    continue;
                }

                if(relationMap.containsKey(relation)) {
                    relationMap.replace(relation, relationMap.get(relation) + 10);
                } 
                else {
                    relationMap.put(relation, 10);
                }
            }
        }

        for(String visitor : visitors) {
            if(!friendSet.contains(visitor)) {
                if(relationMap.containsKey(visitor)) {
                    relationMap.replace(visitor, relationMap.get(visitor) + 1);
                } 
                else {
                    relationMap.put(visitor, 1);
                }
            }
        }

        answer = new ArrayList<>(relationMap.keySet());
        Collections.sort(answer, (o1, o2) -> (relationMap.get(o2).compareTo(relationMap.get(o1))));

        if(answer.size() > 5)
        	answer = answer.subList(0, 5);

        return answer;
    }
}