package onboarding;

import java.util.*;
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();
        Map<String, Integer> friendsScore = new HashMap<>();
        List<String> resultFineMyFriend = findMyFriend(user, friends);

        friendsScore = getFriendsFriendsScore(friendsScore, resultFineMyFriend,friends);
        friendsScore = getVisitorsScore(friendsScore,visitors);

        return answer;
    }

    public static List<String> findMyFriend(String user, List<List<String>> friends){

        String newString;
        List<String> friend = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            for (int j = 0; j < friends.get(i).size(); j++){
                if(friends.get(i).get(j).equals(user)){
                    List<String> newList = new ArrayList<>(friends.get(i));
                    newList.remove(user);
                    newString = String.join(",", newList);
                    friend.add(newString);
                }
            }
        }
        return friend;
    }

    public static Map<String, Integer> getFriendsFriendsScore(Map<String, Integer> friendsScore,List<String> resultFineMyFriend,List<List<String>> friends){

        for (int i = 0; i < resultFineMyFriend.size(); i++) {
            List<String> myFriendsFriends = findMyFriend(resultFineMyFriend.get(i), friends);

            for (int j = 0; j < myFriendsFriends.size(); j++) {

                friendsScore.put(myFriendsFriends.get(j),friendsScore.getOrDefault(myFriendsFriends.get(j), 0) + 10);
            }
        }

        return friendsScore;
    }

    public static Map<String, Integer> getVisitorsScore(Map<String, Integer> friendsScore,List<String> visitors){

        for (int i = 0; i < visitors.size(); i++) {
            friendsScore.put(visitors.get(i),friendsScore.getOrDefault(visitors.get(i), 0) + 1);
        }

        return friendsScore;
    }
}
