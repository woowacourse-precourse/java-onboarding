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
    	List<String> answerList = new ArrayList<String>();
    	Map<String,Set<String>> friendMap = new HashMap<String,Set<String>>();
    	Map<String,Integer> candidatesMap = new HashMap<String,Integer>();
    	Map<Integer,List<String>> reverseCandidatesMap = new HashMap<Integer,List<String>>();
    	
        for(List<String> friendShip: friends) {
        	for(int i = 0; i<2; i++) {
        		if(friendMap.containsKey(friendShip.get(i))) {
    				Set<String> friendSet = friendMap.get(friendShip.get(i));
    				friendSet.add(friendShip.get(i^1));
	        	}else {
    				Set<String> set = new HashSet<String>();
    				set.add(friendShip.get(i^1));
    				friendMap.put(friendShip.get(i), set);
	        	}
        		candidatesMap.put(friendShip.get(i),0);
        	}
        }
        
        for(String userFriend : friendMap.get(user)) {
        	for(String friendOfFriend : friendMap.get(userFriend)) {
        		candidatesMap.put(friendOfFriend,candidatesMap.get(friendOfFriend)+10);
        	}
        }
        
        for(String visitor : visitors) {
        	if(candidatesMap.containsKey(visitor)) {
        		candidatesMap.put(visitor, candidatesMap.get(visitor)+1);
        	}else {
        		candidatesMap.put(visitor, 1);
        	}
        }
        
        candidatesMap.remove(user);
        for(String userFriend : friendMap.get(user)) {
        	candidatesMap.remove(userFriend);
        }
        
        for(Map.Entry<String,Integer> entry :candidatesMap.entrySet()) {
        	List<String> list;
        	if(reverseCandidatesMap.containsKey(entry.getValue())) {
        		list = reverseCandidatesMap.get(entry.getValue());
        	}else {
        		list = new ArrayList<String>();
        	}
        	list.add(entry.getKey());
        	Collections.sort(list);
        	reverseCandidatesMap.put(entry.getValue(), list);
        }
        
        List<Integer> keyList = new ArrayList<Integer>(reverseCandidatesMap.keySet());
        Collections.sort(keyList, Collections.reverseOrder());
        for(Integer key : keyList) {
        	if(key == 0) {
        		return answerList;
        	}else {
        		for(String candidate : reverseCandidatesMap.get(key)) {
        			answerList.add(candidate);
        			if(answerList.size() == 5) {
        				return answerList;
        			}
        		}
        	}
        }
        
        return answerList;
    }
}