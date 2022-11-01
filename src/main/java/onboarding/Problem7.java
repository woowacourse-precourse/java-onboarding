package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Problem7 {

    static final int SCORE_OF_COMMON_FRIEND = 10;
    static final int SCORE_OF_TIMELINE_VISIT = 1;
    static final int MAX_LIST_SIZE = 5;

    static Map<String, ArrayList<String>> friend_map;
    static Map<String, Integer> score_map;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    static void add_relationship(String user1, String user2){

        if(friend_map.containsKey(user1)) {
            friend_map.get(user1).add(user2);
        }
        else {
            friend_map.put(user1, new ArrayList<String>());
            friend_map.get(user1).add(user2);
        }

    }

}
