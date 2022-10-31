package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {
	static Map<String, List<String>> remainUserAndFriends;
	static Map<String, Integer> remainUserAndScore;
	static Set<String> mainUserFriends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        
        remainUserAndFriends = new HashMap<>();
        remainUserAndScore = new HashMap<>();
        mainUserFriends = new HashSet<>();
        
        makeAllFriendship(user, friends);
        //for debug
        System.out.println(mainUserFriends);
        System.out.println(remainUserAndFriends);
        
        increaseScoreMutualFriend();
        //for debug
        System.out.println(remainUserAndScore);
        
        return answer;
    }
    public static void makeAllFriendship(String user, List<List<String>> friends) {
    	
    	String userA = null;
    	String userB = null;
    	for(List<String> friendship: friends) {
    		userA = friendship.get(0);
    		userB = friendship.get(1);
    		
    		if(userA.equals(user)) {
    			mainUserFriends.add(userB);
    		} else if(userB.equals(user)) {
    			mainUserFriends.add(userA);
    		} else {
    			if(!remainUserAndFriends.containsKey(userA)) {
    				remainUserAndFriends.put(userA, new LinkedList<>());
    			}
    			remainUserAndFriends.get(userA).add(userB);
    			
    			if(!remainUserAndFriends.containsKey(userB)) {
    				remainUserAndFriends.put(userB, new LinkedList<>());
    			}
    			remainUserAndFriends.get(userB).add(userA);
    		}
    	}
    }
    public static void increaseScoreMutualFriend() {
    	String name = null;
    	List<String> friends = null;
    	
    	for(Entry<String, List<String>> friendship: remainUserAndFriends.entrySet()) {
    		name = friendship.getKey();
    		friends = friendship.getValue();
    		for(String friend: friends) {
    			if(mainUserFriends.contains(friend)) {
    				increaseTen(name);
    			}
    		}
    	}
    }
    public static void increaseTen(String name) {
    	remainUserAndScore.put(name, remainUserAndScore.getOrDefault(name, 0) + 10);
    }
}