package onboarding;

import java.util.*;
import java.util.HashMap;
//import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> find_UserFriend(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();

        for(List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);

            // If [idA, idB] contains 'user' then add to userFriend list else do not add
            if ( idA.contains(user) ) {
                userFriend.add(idB);
            }
            else if ( idB.contains(user) ) {
                userFriend.add(idA);
            }
            else {
                continue;
            }
        }
        return userFriend;
    }

    public static void recommandFriendsKnowingTogether(String user
            , Map<String, Integer> score
            , List<String> userFriendList
            , List<List<String>> friends) {
        for(List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);

            boolean isUser = (idA == user) || (idB == user);

            // If elements from userFriendList found on userFriendList then add 10 points
            if ( !isUser ) {
                if (userFriendList.contains(idA)) {
                    score.put( idB, score.getOrDefault(idB, 0) + 10 );
                }
                else if (userFriendList.contains(idB)) {
                    score.put( idA, score.getOrDefault(idA, 0) + 10 );
                }
                else {
                    continue;
                }
            }
        }
    }

    public static void recommandFriendsVisitingTimeline(Map<String, Integer> score
            , List<String> userFriendList
            , List<String> visitors) {
        // If elements from visitorsList can not be found on userFriendList then add 1 point
        for (String visitor : visitors) {
            if ( !userFriendList.contains(visitor) ) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
            else {
                continue;
            }
        }
    }

    public static List<String> sortRecommandFriends(Map<String, Integer> score) {
        List<String> recommandList = new ArrayList<>(score.keySet()); // Get keys(name)
        // Do sort by descending score
        Collections.sort(recommandList, (value1, value2) -> (score.get(value2).compareTo(score.get(value1))));

        return recommandList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> score = new HashMap<>(); // Using key-value

        List<String> userFriendList = find_UserFriend(user, friends);
        recommandFriendsKnowingTogether(user, score, userFriendList, friends);
        recommandFriendsVisitingTimeline(score, userFriendList, visitors);
        List<String> answer = sortRecommandFriends(score);

        return answer;
    }
}
