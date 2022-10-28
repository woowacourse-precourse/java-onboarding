package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        
        // user와 친구         
        HashSet<String> userFriends = new HashSet<>();     
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
        
        return answer;
    }
}
