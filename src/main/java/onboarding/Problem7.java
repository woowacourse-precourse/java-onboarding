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
	private static Map<String, List<String>> remainUserAndFriends;
	private static Map<String, Integer> remainUserAndScore;
	private static Set<String> mainUserFriends;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        
        remainUserAndFriends = new HashMap<>();
        remainUserAndScore = new HashMap<>();
        mainUserFriends = new HashSet<>();

        makeAllFriendship(user, friends);
        
        increaseScoreMutualFriend();
        increaseScoreVisitors(user, visitors);
        
        List<Friend> candidateFriendList = new ArrayList<>();
        makeCandidateFriendList(candidateFriendList);
        sortByScoreThenName(candidateFriendList);
        List<String> answer = getFinalFriendList(candidateFriendList);

        return answer;
    }
	private static void makeAllFriendship(String user, List<List<String>> friends) {
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
    private static void increaseScoreMutualFriend() {
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
    private static void increaseScoreVisitors(String user, List<String> visitors) {
    	for(String visitor: visitors) {
    		if(visitor.equals(user)) {
    			continue;
    		}
    		increaseOne(visitor);
    	}
    }
    private static void increaseTen(String name) {
    	remainUserAndScore.put(name, remainUserAndScore.getOrDefault(name, 0) + 10);
    }
    private static void increaseOne(String name) {
    	remainUserAndScore.put(name, remainUserAndScore.getOrDefault(name, 0) + 1);
    }
    private static void makeCandidateFriendList(List<Friend> list) {
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
    private static void sortByScoreThenName(List<Friend> list) {
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
    private static List<String> getFinalFriendList(List<Friend> candidateFriendList) {
    	List<String> finalFriendList = new ArrayList<>();
    	int cnt = 0;
    	
    	for(Friend friend: candidateFriendList) {
    		finalFriendList.add(friend.name);
    		cnt += 1;
    		if(cnt == 5) {
    			break;
    		}
    	}
		return finalFriendList;
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