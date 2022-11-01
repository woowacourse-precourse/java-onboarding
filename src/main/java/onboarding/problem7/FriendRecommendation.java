package onboarding.problem7;

import java.util.*;

public class FriendRecommendation {
    private String user;
    private List<List<String>> friends;
    private List<String> visitors;
    private Map<String, List<String>> friendMap = new HashMap<>();
    private List<String> usersFriendList;
    private Map<String, Integer> friendScore = new HashMap<>();

    public FriendRecommendation(String user, List<List<String>> friends, List<String> visitors){
        this.user = user;
        this.friends = friends;
        this.visitors = visitors;
    }

    private void makeFriendGraph(){
        for (List<String> friend : friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friendMap.containsKey(friend1)) {
                friendMap.get(friend1).add(friend2);
            }
            else {
                friendMap.put(friend1, new ArrayList<>(List.of(friend2)));
            }

            if (friendMap.containsKey(friend2)) {
                friendMap.get(friend2).add(friend1);
            }
            else {
                friendMap.put(friend2, new ArrayList<>(List.of(friend1)));
            }
        }
    }

    private void countBothKnowFriends(){
        usersFriendList = friendMap.getOrDefault(user, Collections.emptyList());
        if (!usersFriendList.isEmpty()){
            for(String keyUser : friendMap.keySet()){
                if (keyUser.equals(user))
                    continue;
                if (usersFriendList.contains(keyUser))
                    continue;
                for (String valFriend : friendMap.get(keyUser)){
                    if (usersFriendList.contains(valFriend))
                        friendScore.put(keyUser, friendScore.containsKey(keyUser) ? friendScore.get(keyUser) + 1 : 1);
                }
            }
        }
        friendScore.replaceAll((u, v) -> friendScore.get(u) * 10);
    }
}
