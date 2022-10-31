package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem7 {

    public static void updateMyFriend(ArrayList<String> myFriends, String newFriend){
        myFriends.add(newFriend);
    }

    public static ArrayList<String> setMyFriend(String newFriend){
        ArrayList<String> myNewFriends = new ArrayList<>();
        myNewFriends.add(newFriend);
        return myNewFriends;
    }

    public static HashMap<String, ArrayList<String>> createFriendConnection (List<List<String>> friends){
        HashMap<String, ArrayList<String>> friendConnection = new HashMap<>();

        for (List<String> friend : friends){
            ArrayList<String> arrList = new ArrayList<>(friend);
            String friend1 = arrList.get(0);
            String friend2 = arrList.get(1);

            if (friendConnection.containsKey(friend1)){
                ArrayList<String> myFriends = friendConnection.get(friend1);
                updateMyFriend(myFriends, friend2);
                friendConnection.put(friend1, myFriends);
            } else{
                ArrayList<String> myFriend = setMyFriend(friend2);
                friendConnection.put(friend1, myFriend);
            }

            if (friendConnection.containsKey(friend2)){
                ArrayList<String> myFriends = friendConnection.get(friend2);
                updateMyFriend(myFriends, friend1);
                friendConnection.put(friend2, myFriends);
            } else{
                ArrayList<String> myFriend = setMyFriend(friend2);
                friendConnection.put(friend1, myFriend);
            }
        }

        return friendConnection;
    }

    public static Map<String, Integer> createScoreTable(String user, Map<String, ArrayList<String>> friendConnection){
        ArrayList<String> userFriends = friendConnection.get(user);
        HashMap<String, Integer> scoreTable = new HashMap<>();
        HashSet<String> notRecommended = new HashSet<>(userFriends);
        notRecommended.add(user);

        for (String userFriend: userFriends){
            ArrayList<String> friendsOfFriend = friendConnection.get(userFriend);
            for (String friendOfFriend : friendsOfFriend){
                if (notRecommended.contains(friendOfFriend))
                    continue;

                if (scoreTable.containsKey(friendOfFriend)){
                    int score = scoreTable.get(friendOfFriend);
                    score += 10;
                    scoreTable.replace(friendOfFriend, score);
                } else {
                    int score = 10;
                    scoreTable.put(friendOfFriend, score);
                }

            }
        }

        return scoreTable;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, ArrayList<String>> friendConnection = createFriendConnection(friends);
        Map<String, Integer> scoreTable = createScoreTable(user, friendConnection);

        return answer;
    }
}
