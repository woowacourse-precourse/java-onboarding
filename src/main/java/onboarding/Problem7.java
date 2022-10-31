package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Problem7 {
	public static class Pair {
		private int score;
		private String name;
		
		public Pair(int score, String name) {
			this.score = score;
			this.name = name;
		}
		
		public int getScore() {
			return score;
		}
		
		public String getName() {
			return name;
		}
	}
	
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	List<String> answer = new ArrayList<>();
        List<String> alreadyFriends = new ArrayList<>();
        TreeMap<String, Integer> notFriends = new TreeMap<>();
                
        for(List<String> friend : friends) {
        	if(friend.get(0).equals(user)) alreadyFriends.add(friend.get(1));
        	if(friend.get(1).equals(user)) alreadyFriends.add(friend.get(0));
        }
 
        for(List<String> friend : friends) {
        	for(String name : alreadyFriends) {
        		if(friend.get(0).equals(name)) notFriends.merge(friend.get(1), 10, Integer::sum);
            	if(friend.get(1).equals(name)) notFriends.merge(friend.get(0), 10, Integer::sum);
        	}
        }
        
        for(String name : visitors) notFriends.merge(name, 1, Integer::sum);  
    	for(String name : alreadyFriends) {
    		notFriends.remove(name);
    	}
		notFriends.remove(user);
        
        List<Pair> pairList = new ArrayList<>();
        
        for(String name: notFriends.keySet()) {
        	Pair pair = new Pair(notFriends.get(name), name);
        	pairList.add(pair);
        }
        
        Collections.sort(pairList, new Comparator<Pair>() {
        	public int compare(Pair p1, Pair p2) {
        		if(p1.score < p2.score) return 1;
        		else if(p1.score > p2.score) return -1;
        		else return p1.name.compareTo(p2.name);
        	}
        });
        
       for(Pair pair : pairList) {
    	   answer.add(pair.name);
       }
        
        
        return answer;
    }
}
