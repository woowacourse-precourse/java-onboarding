package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String, Integer> friendCandidate = new HashMap<>();
    private static Set<String> oldFriend = new HashSet<>();
    private static List<List<String>> friendData;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getRecomendedFriends(user,friends,visitors);
        return answer;
    }

    private static List<String> getRecomendedFriends(String user, List<List<String>> friends, List<String> visitors){
        oldFriend.add(user);
        friendData=friends;
        List<String> olderFriends = getFriendOfUser(user);
        classifyOlderFriend(olderFriends);
    }

    private static List<String> getFriendOfUser(String user) {
        List<String> friendList = new ArrayList<>();
        for(int i=0; i<friendData.size(); i++){
            if(friendData.get(i).contains(user)){
                int friendIndex = (friendData.get(i).indexOf(user)+1)%2;
                friendList.add(friendData.get(i).get(friendIndex));
            }
        }
        return friendList;
    }

    private static void classifyOlderFriend(List<String> oldfriends){
        oldfriends.stream().forEach(a->oldFriend.add(a));
    }

}
