package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        int maxRcm = 5;
        List<String> answer = new ArrayList<>();
        HashMap<String, List<String>> friendsList = new HashMap<String, List<String>>();
        HashMap<String, Integer> friendScore = new HashMap<String, Integer>();

        return answer;
    }

    static HashMap<String, List<String>> relateFriend(List<List<String>> friends) {

        HashMap<String, List<String>> friendsList = new HashMap<String, List<String>>();

        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            if (friendsList.containsKey(name1)) {
                friendsList.get(name1).add(name2);
                continue;
            }
            friendsList.put(name1, new ArrayList<>(List.of(name2)));
        }

        return friendsList;
    }


}
