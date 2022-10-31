package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Problem7{
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriend = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        
        for(List<String> list:friends) {
        	if(list.get(0).equals(user))
        		userFriend.add(list.get(1));
        	else if(list.get(1).equals(user))
        		userFriend.add(list.get(0));
        }
        
        for(List<String> list:friends) {
        	for(String s:userFriend) {
            	if(list.get(0).equals(s))
            		map.put(list.get(1),map.getOrDefault(list.get(1), 0)+10);
            	else if(list.get(1).equals(s))
            		map.put(list.get(0),map.getOrDefault(list.get(0), 0)+10);
            }
        }
        
        for(String s:visitors)
        	map.put(s,map.getOrDefault(s, 0)+1);
        
        map.remove(user);
        for(String s:userFriend)
        	map.remove(s);
        
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
			{
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		int i = 0;
		
		for(Entry<String, Integer> entry : list_entries) {
			answer.add(entry.getKey());
			if(++i==5)
				break;
		}
        
        return answer;
    }
}
