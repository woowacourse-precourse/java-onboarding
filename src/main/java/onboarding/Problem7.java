package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, List<String>> friendship = new HashMap<>();

        makeFriendship(friends, friendship);



        return answer;
    }

    public static void makeFriendship(List<List<String>> friends, HashMap<String, List<String>> friendship) {
        String crew1, crew2;

        for (List<String> friend : friends) {
            crew1 = friend.get(0);
            crew2 = friend.get(1);

            addFriendship(friendship, crew1, crew2);
            addFriendship(friendship, crew2, crew1);
        }
    }

    private static void addFriendship(HashMap<String, List<String>> friendship, String crew1, String crew2) {
        List<String> relationship;

        if (friendship.get(crew1) == null) {
            List<String> list = new ArrayList<>();
            list.add(crew2);
            friendship.put(crew1, list);
            return;
        }
        relationship = friendship.get(crew1);
        relationship.add(crew2);
        friendship.put(crew1, relationship);
    }
}
