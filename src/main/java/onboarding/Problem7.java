package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> scoreCard = new HashMap<>();
    static HashMap<String, Set<String>> friendList = new HashMap<>();
    
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        String friend1 = "";
        String friend2 = "";
        for(int i=0; i<friends.size(); i++){
            friend1 = friends.get(i).get(0);
            friend2 = friends.get(i).get(1);

            if(friendList.get(friend1)==null)
                friendList.put(friend1, new HashSet<>() {
                });

            friendList.get(friend1).add(friend2);

            if(friendList.get(friend2)==null)
                friendList.put(friend2, new HashSet<>());

            friendList.get(friend2).add(friend1);

        }

        friend_of_friend(user);

        List<String> answer = List.of();
        return answer;
    }

    private static void friend_of_friend(String user) {
        for(String friend: friendList.get(user)){
            for(String stranger:friendList.get(friend)){

                scoreCard.putIfAbsent(stranger, 0);
                scoreCard.put(stranger,scoreCard.get(stranger)+10);
            }
        }
    }
}
