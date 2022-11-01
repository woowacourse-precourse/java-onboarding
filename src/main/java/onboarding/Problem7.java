package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static Map<String, ArrayList<String>> overOneBridge(List<List<String>> friends) {

        Map<String, ArrayList<String>> friendOfFriend = new HashMap<>();

        for(List<String> edge : friends) {

            String name = edge.get(0);
            String friendWith = edge.get(1);

            if(!friendOfFriend.containsKey(name)) {

                friendOfFriend.put(name, new ArrayList<>());
                friendOfFriend.get(name).add(friendWith);
            }
            else {

                friendOfFriend.get(name).add(friendWith);
            }
        }

        return friendOfFriend;
    }

}
