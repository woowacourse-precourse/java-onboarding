package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static ArrayList<String> userFriend = new ArrayList<>();
    static HashMap<String, Integer> recommendList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        getFriends(user, friends);
        countVisited(visitors);

        return answer;
    }

    public static void getFriends(String user, List<List<String>> friends) {
        int index;
        List<String> friendsList;

        for (index = 0; index < friends.size(); index++) {

            friendsList = friends.get(index);

            if (friendsList.get(0).equals(user)) {
                userFriend.add(friendsList.get(1));
            }

            if (friendsList.get(1).equals(user)) {
                userFriend.add(friendsList.get(0));
            }
        }

    }

    public static void countVisited(List<String> visitors) {
        int index;
        int score;

        for(index = 0; index < visitors.size(); index++) {
            if (userFriend.contains(visitors.get(index))){
                continue;
            }

            if (recommendList.containsKey(visitors.get(index))) {
                score = recommendList.get(visitors.get(index));
                score += 1;
                recommendList.put(visitors.get(index), score);
                continue;
            }

            recommendList.put(visitors.get(index), 1);
        }

    }

}
