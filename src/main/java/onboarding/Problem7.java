package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String,Object> friend = new HashMap<>();
        Map<String,Integer> recomd = new TreeMap<>();
        List<Integer> valueList;
        List<String> keyList = new ArrayList<>();
        String[] key_arr;
        
        for(int i=0;i<friends.size();i++) {
        	if(friends.get(i).contains(user)) {
        		for(int j=0;j<2;j++) {
        			friend.put(friends.get(i).get(j),"");
        		}
        	}
        }
        
        friend.remove(user);
        
        for(String key:friend.keySet()) {
        	for(int i=0;i<friends.size();i++) {
        		if(friends.get(i).contains(key)&&!friends.get(i).contains(user)) {
        			recomd.put(friends.get(i).get(0),recomd.getOrDefault(friends.get(i).get(0), 0)+10);
        			recomd.put(friends.get(i).get(1),recomd.getOrDefault(friends.get(i).get(1), 0)+10);
        		}
        	}
        	recomd.remove(key);
        }
        
        for(int i=0;i<visitors.size();i++) {
        	recomd.put(visitors.get(i),recomd.getOrDefault(visitors.get(i),0)+1);
        }
        
        for(String key:friend.keySet()) {
        	if(recomd.containsKey(key)) {
        		recomd.remove(key);
        	}
        }
        
        valueList = new ArrayList<>(recomd.values());
        
        Collections.sort(valueList,Collections.reverseOrder());

        for(int i=0;i<valueList.size();i++) {
        	if(valueList.get(i)==0)continue;
        	else {
        		for(String key:recomd.keySet()) {
        			if(recomd.get(key)==valueList.get(i)) {
        				keyList.add(key);
        				recomd.remove(key);
        				break;
        			}
        				
        		}
        	}
        }
        
        if(keyList.size()>5) {
        	for(int i=5;i<keyList.size();i++) {
        		keyList.remove(5);
        	}
        }
        
        key_arr = new String[keyList.size()];
        
        for(int i=0;i<key_arr.length;i++) {
        	key_arr[i]=keyList.get(i);
        }
        
        answer = List.of(key_arr);
        
        return answer;
    }
}
