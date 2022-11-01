package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //List<String> answer = Collections.emptyList();
        List<String> answer = new ArrayList<>();
        List<String> userFriend = new ArrayList<>(); //user의 친구
        List<String> userFriendFriend = new ArrayList<>(); //user의 친구의 친구
        HashMap<String, Integer> score = new HashMap<>();

        for(List<String> friend : friends) {
            if(user.equals(friend.get(0))) {
                userFriend.add(friend.get(1));
            }
            if(user.equals(friend.get(1))) {
                userFriend.add(friend.get(0));
            }
        }

        for(String friendId : userFriend) {
            for(List<String> friend : friends) {
                if(friendId.equals(friend.get(0))) {
                    userFriendFriend.add(friend.get(1));
                }
                if(friendId.equals(friend.get(1))) {
                    userFriendFriend.add(friend.get(0));
                }
            }

            for(String friendFriendId : userFriendFriend) {
                if(!user.equals(friendFriendId) && !userFriend.contains(friendFriendId)) {
                    score.put(friendFriendId, score.getOrDefault(friendFriendId, 0) + 10);
                }
            }
        }

        for(String visitor : visitors) {
            if(!userFriend.contains(visitor)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }

        List<String> keySetList = new ArrayList<>(score.keySet());
        Collections.sort(keySetList, (o1, o2) -> (score.get(o2).compareTo(score.get(o1))));

        int num = Math.min(score.size(), 5);
        for(int i = 0; i < num; i++) {
            answer.add(keySetList.get(i));
        }

        return answer;
    }
}
