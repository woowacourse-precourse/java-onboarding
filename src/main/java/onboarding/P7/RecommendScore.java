package onboarding.P7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendScore {
    public  Map<String, Integer> recommendScore(String user, List<List<String>> friends, List<String> visitors){
        FriendList friendList = new FriendList();
        List<String> userFriend = friendList.friendsList(user,friends);
        List<String> friendOfFriend = friendList.FriendOfFriend(user, friends, userFriend);
        return ScoreMap(visitors, userFriend, friendOfFriend);
    }

    private static Map<String, Integer> ScoreMap(List<String> visitors, List<String> friendList, List<String> friendandfriend){
        List<String> visit = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        int sum =0;
        int sum2 =0;
        visitors = visitors.stream().filter(x -> !friendList.contains(x)).collect(Collectors.toList());
        for(String v: visitors){
            sum += 1;
            map1.put(v, sum);
        }
        for(String a: friendandfriend){
            sum2 += 10;
            map1.put(a, sum2);
        }
        return map1;

    }


}
