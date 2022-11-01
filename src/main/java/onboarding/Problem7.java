package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		String user1 = user;
		String s = new String();
		int i, j, g, k;
		List<String> a = new ArrayList<>();
		List<String> visitors1 = visitors;
        List<List<String>> friends1 = friends;
		
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(i = 0; i < friends1.size(); i++) {
        	for(j = 0; j < 2; j++) {
        		map.put(friends1.get(i).get(j), 0);
        		
        		/*
				 * if(friends.get(i).get(j).equals(user)) { score += 10;
				 * map.put(friends.get(i).get(0), 0); }
				 */
        	}
        }
        
        List<String> result = new ArrayList<>();
        for(i = 0; i < visitors1.size(); i++) {
        	map.put(visitors1.get(i), 0);
        }
        
        
        for(i = 0; i < friends1.size(); i++) {
        	for(j = 0; j < 2; j++) {
        		
        		if(friends1.get(i).get(j).equals(user1)) {
        			if(j == 0) {
        				s = friends1.get(i).get(1);
        				a.add(s);
        				
        				
        				for(k = 0; k < friends1.size(); k++) {
        					for(g = 0; g < 2; g++) {
        						if(friends1.get(k).get(g).equals(s)) {
        							if(g == 0) {
        								map.replace(friends1.get(k).get(1), map.get(friends1.get(k).get(g)) + 10);
        							}
        							else if(g == 1) {
        								map.replace(friends1.get(k).get(0), map.get(friends1.get(k).get(g)) + 10);
        							}
        						}
        					}
        				}
        			}
        			else if(j == 1){
        				
        				s = friends1.get(i).get(0); // donut
        				a.add(s);
        				for(k = 0; k < friends1.size(); k++) {
        					for(g = 0; g < 2; g++) {
        						if(friends1.get(k).get(g).equals(s)) {
        							if(g == 0) {
        								map.replace(friends1.get(k).get(1), map.get(friends1.get(k).get(g)) + 10);
        							}
        							else if(g == 1) {
        								map.replace(friends1.get(k).get(0), map.get(friends1.get(k).get(g)) + 10);
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        }
        
		/*
		 * for(i = 0; i < friends.size(); i++) { for(j = 0; j < 2; j++) {
		 * 
		 * if(friends.get(i).get(j).equals(user)) { if(j == 0) { s =
		 * friends.get(i).get(1); } else if(j == 1){ s = friends.get(i).get(0); }//
		 * donut for(k = 0; k < friends.size(); k++) { for(g = 0; g < 2; g++) {
		 * if(friends.get(k).get(g).equals(s)) { if(g == 0) {
		 * map.replace(friends.get(k).get(1), map.get(friends.get(k).get(1)) + 10); }
		 * else if(g == 1) { map.replace(friends.get(k).get(0),
		 * map.get(friends.get(k).get(1)) + 10); } } } } } } }
		 */
        
        
        for(i = 0; i < visitors1.size(); i++) {
        	map.replace(visitors1.get(i), map.get(visitors1.get(i)) + 1);
        }
 
        for(i = 0; i < a.size(); i++) {
        	map.remove(a.get(i));
        }
        		
        map.remove(user1);
        List<String> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list);
        Collections.sort(list,(value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        
        return list;
    }
}
