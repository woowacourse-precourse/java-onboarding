package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        
        /* user와 친구 */         
        List<String> userFriends = new ArrayList<>();     
        for (int i = 0; i < friends.size(); i++) {
            Iterator it = friends.get(i).iterator();
            while(it.hasNext()) {
                Object tmp = it.next();
                if(tmp.equals(user)) {
                    userFriends.addAll(friends.get(i));      
                    userFriends.remove(user);
                }
            }
        }
        
        /* 함께 아는 친구 점수 */
        Map<String, Integer> friendScore = new HashMap<>();
        for (List<String> list : friends) {
            // 이미 친구인 친구는 제외
            if (list.get(0).equals(user) || list.get(1).equals(user)) {
                continue;
            } else if (userFriends.contains(list.get(0))) {
                String key = list.get(1);
                friendScore.put(key, friendScore.getOrDefault(key, 0) + 10);
            } else if (userFriends.contains(list.get(1))) {
                String key = list.get(0);
                friendScore.put(list.get(0), friendScore.getOrDefault(key, 0) + 10);
            }
        }
        
        /* 방문자 점수 */
        Map<String, Integer> visitScore = new HashMap<String, Integer>();        
        for (String str : visitors) {            
            Integer count = visitScore.get(str);            
            if (count == null) {                
                visitScore.put(str, 1);            
            } else {                
                visitScore.put(str, count + 1);            
            }        
        } 
        
        return answer;
    }
}
