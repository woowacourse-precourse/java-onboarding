package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> myFriendsList = myFriends(user, friends);
        HashMap<String, Integer> score = new HashMap<>();

        for (String myFriend : myFriendsList) {
            for (String recomendedFriends : myFriends(myFriend, friends)) {
                if (!recomendedFriends.equals(user)) {
                    addRecomendedScore(score, recomendedFriends);
                }
            }
        }



        System.out.println("score = " + score);

        return myFriendsList;
    }

    private static void addRecomendedScore(HashMap<String, Integer> recomendedFriend, String id) {
        if (recomendedFriend.containsKey(id)) {
            recomendedFriend.put(id, recomendedFriend.get(id) + 10);
        } else {
            recomendedFriend.put(id, 10);
        }
    }

    private static List<String> myFriends(String user, List<List<String>> friends) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            String idA = friends.get(i).get(0);
            String idB = friends.get(i).get(1);
            if (user.equals(idA)) {
                list.add(idB);
            }
            if (user.equals(idB)) {
                list.add(idA);
            }
        }
        return list;
    }
}
