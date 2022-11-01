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
        
        for(int i=0; i<friends.size(); i++) {
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

        for(int i=0; i<visitors.size(); i++) {
        	if(!userFriends.contains(visitors.get(i))) {
        		if(!scoreMap.containsKey(visitors.get(i))) scoreMap.put(visitors.get(i), visit);
        		else scoreMap.put(visitors.get(i), scoreMap.get(visitors.get(i))+visit);        		
        	}

        	for(int j=0; j<userFriends.size(); j++) {
        		if(visitors.get(i)==userFriends.get(j)) {
        			for(int k=0; k<friends.size(); k++) {
        				if(friends.get(k).get(0).equals(visitors.get(i)) && !friends.get(k).get(1).equals(user)){
        					if(!scoreMap.containsKey(friends.get(k).get(1))) scoreMap.put(friends.get(k).get(1), knowFriend);
        					else scoreMap.put(friends.get(k).get(1), scoreMap.get(friends.get(k).get(1))+knowFriend);
        				}
        			}
        		}
        	}
        }        
        answer = new ArrayList<String>(scoreMap.keySet());
        
        return answer;
    }
}
