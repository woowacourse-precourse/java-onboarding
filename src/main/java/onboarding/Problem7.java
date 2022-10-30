package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
        Map<String, Integer> visitScore = new HashMap<>();        
        for (String str : visitors) {            
            Integer count = visitScore.get(str);            
            if (count == null) {                
                visitScore.put(str, 1);            
            } else {                
                visitScore.put(str, count + 1);            
            }        
        } 
        
        /* 추천 점수 합치기 */
        visitScore.forEach((key, value) -> friendScore.merge(key, value, (v1, v2) -> v1 + v2));
        for (int i = 0; i < userFriends.size(); i++) {
            friendScore.containsKey(userFriends.get(i));
            friendScore.remove(userFriends.get(i));
        }

        /* Value값이 큰 순서대로 정렬 */
        List<String> result = new ArrayList<>(friendScore.keySet());
    	Collections.sort(result, (v1, v2) -> (friendScore.get(v2).compareTo(friendScore.get(v1))));
        
        return answer = result;
    }
}
