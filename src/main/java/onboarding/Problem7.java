package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> findFriends = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
        int knowFriend = 10;
        int visit = 1;
        
        // 유저의 친구 목록
        for(int i=0; i<friends.size(); i++) { // 6
        	for(int j=0; j<2; j++) {
        		if(friends.get(i).get(0).equals(user)) {
        			findFriends.add(friends.get(i).get(1));
        		}else if(friends.get(i).get(1).equals(user)) {
        			findFriends.add(friends.get(i).get(0));
        		}
        	}
        }
        for(String friend : findFriends) {
        	if(!userFriends.contains(friend)) userFriends.add(friend);
        }
        findFriends.clear();
        
        // 방문자 확인
        for(int i=0; i<visitors.size(); i++) { // 5
        	// 방문 했을 때 점수 추가
        	if(!userFriends.contains(visitors.get(i))) {
        		if(!scoreMap.containsKey(visitors.get(i))) scoreMap.put(visitors.get(i), visit);
        		else scoreMap.put(visitors.get(i), scoreMap.get(visitors.get(i))+visit);        		
        	}

        	
        	for(int j=0; j<userFriends.size(); j++) { // 유저의 친구 목록
        		// 유저의 친구 목록에 방문자가 있을 때
        		if(visitors.get(i)==userFriends.get(j)) {
        			for(int k=0; k<friends.size(); k++) { // 6
        				if(friends.get(k).get(0).equals(visitors.get(i)) && !friends.get(k).get(1).equals(user)){
        					if(!scoreMap.containsKey(friends.get(k).get(1))) scoreMap.put(friends.get(k).get(1), knowFriend);
        					else scoreMap.put(friends.get(k).get(1), scoreMap.get(friends.get(k).get(1))+knowFriend);
        				}
        			}
        		}
        	}
        }
        
        // 점수
        scoreMap.forEach((key, value) -> {
        	System.out.println(key + " : " + value);
        });
        
        return answer;
    }
}
