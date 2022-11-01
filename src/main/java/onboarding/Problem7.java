package onboarding;

import java.util.*;

public class Problem7 {
    public static void makeNonFriendList(String user,List<List<String>> friends,List<String> myFriend,List<String> nonFriend,List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        int score = 0;
        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            for (int j = 0; j < myFriend.size(); j++) {
                if (!friend.contains(user) && friend.get(0).equals(myFriend.get(j)) && !friend.get(1).equals(myFriend.get(j))) {
                    if (!nonFriend.contains(friend.get(1))) {
                        nonFriend.add(friend.get(1));
                        scoreMap.put(friend.get(1), score + 10);
                    } else {//이미 존재
                        scoreMap.replace(friend.get(1), scoreMap.get(friend.get(1)) + 10);

                    }

                } else if (!friend.contains(user) && !friend.get(0).equals(myFriend.get(j)) && friend.get(1).equals(myFriend.get(j))) {
                    if (!nonFriend.contains(friend.get(0))) {
                        nonFriend.add(friend.get(0));
                        scoreMap.put(friend.get(0), score + 10);
                    } else {//이미 존재
                        scoreMap.replace(friend.get(0), scoreMap.get(friend.get(0)) + 10);

                    }
                }
            }
        }
    }
    public static void makeFriendList(String user,List<List<String>> friends,List<String> myFriend){

        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            if(friend.contains(user)){
                String myF = friend.indexOf(user) == 0 ? friend.get(1) : friend.get(0);
                myFriend.add(myF);

            }
        }

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myFriend = new ArrayList<>();
        List<String> nonFriend = new ArrayList<>();

        makeFriendList(user,friends,myFriend);
        makeNonFriendList(user,friends,myFriend,nonFriend,visitors);
        return answer;
    }
}
