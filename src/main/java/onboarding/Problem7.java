package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String,Integer> hashmap = new HashMap<String,Integer>();

        for(int i = 0; i< friends.size(); i++){
            for (int j =0 ; j< 2;j++){
                if (!hashmap.containsKey(friends.get(i).get(j))){
                    hashmap.put(friends.get(i).get(j),0);
                }
                int tmp = hashmap.get(friends.get(i).get(j));
                hashmap.put(friends.get(i).get(j),tmp+10);
            }
        }

        for(int i = 0; i< visitors.size(); i++){
            if (!hashmap.containsKey(friends.get(i))){
                hashmap.put(friends.get(i).get(1),0);
            }
            int tmp = hashmap.get(friends.get(i));
            hashmap.put(friends.get(i).get(i),tmp+1);
        }

        return answer;
    }
}
