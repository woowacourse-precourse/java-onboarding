package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = getUserFriends(user, friends);
        
        return answer;
    }
    
    private static List<String> getUserFriends(String user, List<List<String>> list){
    	List<String> userFriends = new ArrayList<>();
    	
    	for(int i = 0; i < list.size(); i++) {
    		if(list.get(i).get(0).equals(user)) {
    			userFriends.add(list.get(i).get(1));
    		} else if(list.get(i).get(1).equals(user)) {
    			userFriends.add(list.get(i).get(0));
    		}
    	}
    	
    	return userFriends;
    }
    
    private static Map<String, Integer> calculateScoreFriendOfFriend(List<List<String>> friends, List<String> userFriends){
    	Map<String, Integer> scoreMap = new HashMap<>();
    	
    	for(int i = 0; i < friends.size(); i++) {
    		for(int j = 0; j < friends.get(i).size(); j++) {
    			int score = 0;
    			
    			if(isFriendOfFriend(friends.get(i).get(j), userFriends)) {
    				score = 10;
    			}
    			
    			if(scoreMap.containsKey(friends.get(i).get(1 - j))) {
    				scoreMap.replace(friends.get(i).get(1 - j), scoreMap.get(friends.get(i).get(1 - j)) + score);
    				continue;
    			}
    			scoreMap.put(friends.get(i).get(1 - j), score);
    		}
    	}
    	return scoreMap;
    }
    
    private static boolean isFriendOfFriend(String id, List<String> userFriends) {
    	return userFriends.contains(id);
    }
    
    private static Map<String, Integer> calculateScoreVisitors(List<String> visitors, Map<String, Integer> scoreMap){
    	for(int i = 0; i < visitors.size(); i++) {
    		if(scoreMap.containsKey(visitors.get(i))) {
    			scoreMap.replace(visitors.get(i), scoreMap.get(visitors.get(i)) + 1);
    			continue;
    		}
    		scoreMap.put(visitors.get(i), 1);
    	}
    	
    	return scoreMap;
    }
}
