package onboarding.P7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendScore {
    public Map<String, Integer> giveScroeAll(String user, List<List<String>> friends, List<String> visitors){
        FriendList friendList = new FriendList();
        NotFriendVisitor notFriendVisitor = new NotFriendVisitor();

        Map<String, Integer> memberScore = new HashMap<>();


        for(String friend: friendList.getFriendOfFriend(user, friends)){
            memberScore.put(friend, memberScore.getOrDefault(friend, 0)+10);
        }

        for(String visit : notFriendVisitor.getvisitors(visitors, user, friends)){
            memberScore.put(visit, memberScore.getOrDefault(visit, 0)+1);
        }
        return memberScore;
    }


}
