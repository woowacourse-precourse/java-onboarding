package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = getUserFriends(user, friends);
        
        return answer;
    }
    
    private static List<String> getUserFriends(String user, List<List<String>> list){
    	List<String> userFriends = new ArrayList<>();
    	
    	for(int i = 0; i < list.size(); i++) {
    		if(list.get(i).get(0).equals(user)) {
    			userFriends.add(list.get(i).get(1));
    		} else if(list.get(i).get(1).equals(user)) {
    			userFriends.add(list.get(i).get(0));
    		}
    	}
    	
    	return userFriends;
    }
}
