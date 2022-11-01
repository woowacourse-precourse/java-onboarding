package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, List<String>> userGraph = new HashMap<String, List<String>>();

        for (List<String> friend:friends) {
            getGraph(friend, userGraph);
        }
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void getGraph(List<String> friend, HashMap<String, List<String>> userGraph){
        if(userGraph.containsKey(friend.get(0))){
            userGraph.get(friend.get(0)).add(friend.get(1));
            return;
        }
        userGraph.put(friend.get(0), new ArrayList<>());
        userGraph.get(friend.get(0)).add(friend.get(1));
    }
}

