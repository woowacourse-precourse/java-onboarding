package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    private static void getFriendsList(HashMap<String, List<String>> friendsList, List<List<String>> friends){
        for(int i = 0; i < friends.size(); i++){
            String member1 = friends.get(i).get(0);
            String member2 = friends.get(i).get(1);

            connectFrined(friendsList, member1, member2);
            connectFrined(friendsList, member2, member1);
        }
    }

    private static void connectFrined(HashMap<String, List<String>> friendsList, String member, String friend){
        if(!friendsList.containsKey(member)) {
            List<String> memberFriendsList = new ArrayList<>();
            friendsList.put(member, memberFriendsList);
        }
        friendsList.get(member).add(friend);
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, List<String>> friendsList = new HashMap<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        getFriendsList(friendsList, friends);

        return answer;
    }
}

