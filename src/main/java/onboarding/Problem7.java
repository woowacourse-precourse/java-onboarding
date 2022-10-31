package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static List<String> findMyFriend(String user, List<List<String>> friends) {
        List<String> realFriend = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(1).equals(user)){
                realFriend.add(friends.get(i).get(0));
            }
        }
        return realFriend;
    }

    public static HashMap<String, Integer> findMyFriendsFriend(String user, List<String> myFriend, List<List<String>> friendsList) {

        HashMap<String, Integer> myFriendsFriend = new HashMap<>();
        for(int i = 0; i < friendsList.size(); i++) {
            int count = 10;
            if (!friendsList.get(i).get(1).equals(user) && myFriend.contains(friendsList.get(i).get(0))) {
                myFriendsFriend.put(friendsList.get(i).get(1), count * 10);
            }
        }
        myFriendsFriend = sortByValue(myFriendsFriend);
        return myFriendsFriend;
    }

    public static HashMap<String, Integer> findMyVisitors(String user, List<String> myFriend, List<String> visitors) {
        HashMap<String, Integer> notMyFriendVisitors = new HashMap<>();
        for(int i = 0; i < visitors.size(); i++) {
            int count = 1;
            for (String f : myFriend) {
                if (!visitors.get(i).equals(f)) {
                    notMyFriendVisitors.put(visitors.get(i), count++);
                }
            }
        }
        return notMyFriendVisitors;
    }

}
