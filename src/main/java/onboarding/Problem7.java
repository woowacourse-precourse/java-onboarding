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
        
        ArrayList<String> user_friend = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < friends.size(); i++) {
        	if(friends.get(i).get(0).equals(user)) {
        		user_friend.add(friends.get(i).get(1));
        	}
        	if(friends.get(i).get(1).equals(user)) {
        		user_friend.add(friends.get(i).get(0));
        	}
        }
        
        for(int i = 0; i < friends.size(); i++) {
        	String first = friends.get(i).get(0);
        	String second = friends.get(i).get(1);
        	if(user_friend.contains(first)) {
        		String too_friend = second;
        		
        		if(too_friend.equals(user)) {
        			continue;
        		}
        		
        		map.put(too_friend, map.containsKey(too_friend) ? map.get(too_friend) + 10 : 10);
        	}
        	if(user_friend.contains(second)) {
        		String too_friend = first;
        		
        		if(too_friend.equals(user)) {
        			continue;
        		}
        		
        		map.put(too_friend, map.containsKey(too_friend) ? map.get(too_friend) + 10 : 10);
        	}
        }
        
        for(int i = 0; i < visitors.size(); i++) {
        	String name = visitors.get(i);
        	if(!user_friend.contains(name)) {
        		map.put(name, map.containsKey(name) ? map.get(name) + 1 : 1);
        	}
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
        	@Override
        	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        		if(o1.getValue() == o2.getValue()) {
        			return o1.getKey().compareTo(o2.getKey());
        		}
        		return o2.getValue() - o1.getValue();
            }
        });
        
        ArrayList<String> arr = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList) {
        	arr.add(entry.getKey());
        }
        return arr;
    }
}
