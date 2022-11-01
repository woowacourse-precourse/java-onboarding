package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    HashMap<String, ArrayList<String>> friendGraph = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        p7.makeFriendGraph(friends);
        return null;
    }

    private void makeFriendGraph(List<List<String>> friends){
        for(List<String> list : friends){
            String friend1 = list.get(0);
            String friend2 = list.get(1);
        }
    }
}
