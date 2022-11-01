package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> allFriendList = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> suggestionList = new HashMap<String, Integer>();

        // make friend list
        friends.forEach((friendInfo) -> {
            String userA = friendInfo.get(0);
            String userB = friendInfo.get(1);
            addFriend(allFriendList, userA, userB);
            addFriend(allFriendList, userB, userA);
        });

        HashSet<String> userFriendList = allFriendList.get(user);

        // add "friend of friend" point
        userFriendList.forEach((friendUser) -> {
            allFriendList.get(friendUser).forEach((suggestionUser) -> {
                addPoint(user, userFriendList, suggestionList, suggestionUser, 10);
            });
        });

        // add unknownUser point
        visitors.forEach((visitor) -> {
            addPoint(user, userFriendList, suggestionList, visitor, 1);
        });

        // sort
        List<String> answer = new ArrayList<>(suggestionList.keySet());
        answer.sort((a, b) -> Integer.compare(suggestionList.get(b), suggestionList.get(a)));
        int endIndex = answer.size() > 5 ? 5 : answer.size();
        return answer.subList(0, endIndex);
    }

    private static void addPoint(String user, HashSet<String> userFriendList, HashMap<String, Integer> suggestionList, String unknownUser, int point) {
        if (!userFriendList.contains(unknownUser) && (unknownUser != user)) {
            if (!suggestionList.containsKey(unknownUser)) {
                suggestionList.put(unknownUser, point);
                return ;
            } else {
                int unknownUserPoint = suggestionList.get(unknownUser);
                suggestionList.put(unknownUser, unknownUserPoint + point);
            }
        }
    }

    private static void addFriend(HashMap<String, HashSet<String>> allFriendList, String userA, String userB) {
        if (!allFriendList.containsKey(userA)) {
            HashSet<String> friendList = new HashSet<String>() {{add(userB);}};
            allFriendList.put(userA, friendList);
            return;
        }
        allFriendList.get(userA).add(userB);
    }
}