package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    private static void getFriendsList(HashMap<String, List<String>> friendsList, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String member1 = friends.get(i).get(0);
            String member2 = friends.get(i).get(1);

            connectFrined(friendsList, member1, member2);
            connectFrined(friendsList, member2, member1);
        }
    }

    private static void connectFrined(HashMap<String, List<String>> friendsList, String member, String friend) {
        if (!friendsList.containsKey(member)) {
            List<String> memberFriendsList = new ArrayList<>();
            friendsList.put(member, memberFriendsList);
        }
        friendsList.get(member).add(friend);
    }

    private static void shareFriends(HashMap<String, List<String>> friendsList, HashMap<String, Integer> recommendScore, String user) {
        for (int i = 0; i < friendsList.get(user).size(); i++) {
            String frinedName = friendsList.get(user).get(i);
            getShareFriendScore(friendsList, recommendScore, frinedName, user);
        }
    }

    private static void getShareFriendScore(HashMap<String, List<String>> friendsList, HashMap<String, Integer> recommendScore, String member, String user) {
        for (int i = 0; i < friendsList.get(member).size(); i++) {
            String friendName = friendsList.get(member).get(i);
            if (friendName.equals(user)) {
                continue;
            }
            if (!recommendScore.containsKey(friendName)) {
                recommendScore.put(friendName, 0);
            }
            recommendScore.put(friendName, recommendScore.get(friendName) + 10);
        }
    }

    private static void getVisitFriendScore(List<String> visitors, HashMap<String, Integer> recommendScore){
        for(int i = 0; i < visitors.size(); i++){
            String visitorName = visitors.get(i);
            if(!recommendScore.containsKey(visitorName)) {
                recommendScore.put(visitorName, 0);
            }
            recommendScore.put(visitorName, recommendScore.get(visitorName) + 1);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriends = new ArrayList<>();
        HashMap<String, List<String>> friendsList = new HashMap<>();
        HashMap<String, Integer> recommendScore = new HashMap<>();

        getFriendsList(friendsList, friends);

        shareFriends(friendsList, recommendScore, user);

        getVisitFriendScore(visitors, recommendScore);

        return answer;
    }
}

