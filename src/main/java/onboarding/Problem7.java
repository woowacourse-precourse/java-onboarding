package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();
		
		Map<String, Integer> score = new HashMap<>();
		
		Map<String, List<String>> f_map = new HashMap<>();

		
		for (List<String> friend:friends) {
					
					String key = friend.get(0);
					
					if (f_map.containsKey(key)) {
						List<String> list = f_map.get(key);
						list.add(friend.get(1));
					}else {
						List<String> list = new ArrayList<>();
						list.add(friend.get(1));
						f_map.put(key, list);
						
					}
					
					key = friend.get(1);
					
					if (f_map.containsKey(key)) {
						List<String> list = f_map.get(key);
						list.add(friend.get(0));
					}else {
						List<String> list = new ArrayList<>();
						list.add(friend.get(0));
						f_map.put(key, list);
					}
					
				}
        
        
		
		Set<Map.Entry<String, List<String>>> entrySet = f_map.entrySet();
		Iterator<Map.Entry<String, List<String>>> entryIterator = entrySet.iterator();
		
		while (entryIterator.hasNext()) {
			Map.Entry<String,List<String>> entry = entryIterator.next();
			String key = entry.getKey();
			List<String> list = entry.getValue();
			
			if (list.contains(user)) {
				for (String person:list) {
					if (!f_map.get(user).contains(person) && person != user){
						if (score.containsKey(person)) {
							Integer val = score.get(person);
							val += 5;
							score.put(person, val);
						} else {
							score.put(person, 5);
						}	
					}
				}
			}
			
		}
		
		for (String visitor:visitors) {
			if (!f_map.get(user).contains(visitor)){
				if (score.containsKey(visitor)){
					Integer val = score.get(visitor);
					val += 1;
					score.put(visitor, val);
				}else {
					score.put(visitor, 1);
				}
			}
		}
		
		
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(score.entrySet());
		
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				int ret = 0;
				if (obj1.getValue() < obj2.getValue()) {
					ret = 1;
				}else if (obj1.getValue() == obj2.getValue()) {
					if (obj1.getKey().compareTo(obj2.getKey()) < 0) {
						ret = -1;
					}else if (obj1.getKey().compareTo(obj2.getKey()) == 0) {
						ret = 0;
					}else if (obj1.getKey().compareTo(obj2.getKey()) > 0) {
						ret = 1;
					}
					
					
				}else if (obj1.getValue() > obj2.getValue()){
					ret = -1;
				}
				return ret;
			}	
		});
		
		for (Entry<String, Integer> entry : list_entries) {
			answer.add(entry.getKey());
			
		}
		
        return answer;
    }
}
