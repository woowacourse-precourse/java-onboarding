package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> findFriends = new ArrayList<>();
        List<String> userFriends = new ArrayList<>();
        
        // 유저의 친구 목록
        for(int i=0; i<friends.size(); i++) { // 6
        	for(int j=0; j<2; j++) {
        		if(friends.get(i).get(0).equals(user)) {
        			findFriends.add(friends.get(i).get(1));
        		}else if(friends.get(i).get(1).equals(user)) {
        			findFriends.add(friends.get(i).get(0));
        		}
        	}
        }
        for(String friend : findFriends) {
        	if(!userFriends.contains(friend)) userFriends.add(friend);
        }
        
        return answer;
    }
}
