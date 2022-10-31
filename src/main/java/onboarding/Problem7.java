package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        increaseScoreVisitors(visitors);
        //for debug
        System.out.println(remainUserAndScore);
        
        List<Friend> candidateFriendList = new ArrayList<>();
        makeCandidateFriendList(candidateFriendList);
        //for debug
        System.out.println(candidateFriendList);
        
        sortByScoreThenName(candidateFriendList);
        //for debug
        System.out.println(candidateFriendList);
        
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
    public static void increaseScoreVisitors(List<String> visitors) {
    	for(String visitor: visitors) {
    		increaseOne(visitor);
    	}
    }
    public static void increaseTen(String name) {
    	remainUserAndScore.put(name, remainUserAndScore.getOrDefault(name, 0) + 10);
    }
    public static void increaseOne(String name) {
    	remainUserAndScore.put(name, remainUserAndScore.getOrDefault(name, 0) + 1);
    }
    public static void makeCandidateFriendList(List<Friend> list) {
    	String name = null;
    	int score = 0;
    	for(Entry<String, Integer> nameAndScore: remainUserAndScore.entrySet()) {
    		name = nameAndScore.getKey();
    		score = nameAndScore.getValue();
    		if(mainUserFriends.contains(name)) {
    			continue;
    		}
    		list.add(new Friend(name, score));
    	}
    }
    public static void sortByScoreThenName(List<Friend> list) {
    	Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Friend o1, Friend o2) {
				if(o1.score == o2.score) {
					return o1.name.compareTo(o2.name);	//이름 오름차순
				}
				return o2.score-o1.score;	//점수 내림차순
			}
		});
    }
}
class Friend {
	String name;
	int score;
	public Friend(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Friend [name=" + name + ", score=" + score + "]";
	}
}