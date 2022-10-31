package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friend = filterFriendByFriendList(friends, user);
        Map<String, Integer> indirectFriendScore = setRecommandFriendScoreByDirectFriend(friends, friend, user);
        setRecommandFriendScoreByVisitor(indirectFriendScore, visitors, friend);

        return friendScoreToListWithOrderByScoreAndNameASC(indirectFriendScore);
    }


    private static List<String> filterFriendByFriendList (List<List<String>> friends, String user) {
        List<String> friendList = new ArrayList<>();

        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                if (friend.get(0).equals(user)) {
                    friendList.add(friend.get(1));
                } else {
                    friendList.add(friend.get(0));
                }
            }
        }

        Collections.sort(friendList);

        return friendList;
    }


    private static Map<String, Integer> setRecommandFriendScoreByDirectFriend(List<List<String>> friends, List<String> directFriends, String user) {
        Map<String, Integer> indirectFriends = new HashMap<>();

        for (List<String> friend : friends) {
            for (String directFriend : directFriends) {
                if (friend.get(0).equals(directFriend)) {
                    indirectFriends.put(friend.get(1), indirectFriends.getOrDefault(friend.get(1), 0) + 10);
                } else if (friend.get(1).equals(directFriend)) {
                    indirectFriends.put(friend.get(0), indirectFriends.getOrDefault(friend.get(0), 0) + 10);
                }
            }
        }

        indirectFriends.remove(user);

        return indirectFriends;
    }


    private static void setRecommandFriendScoreByVisitor(Map<String, Integer> indirectFriend, List<String> visitors, List<String> directFriends) {
        for (String visitor : visitors) {
            if (!directFriends.contains(visitor)) {
                indirectFriend.put(visitor, indirectFriend.getOrDefault(visitor, 0) + 1);
            }
        }
    }


    private static List<String> friendScoreToListWithOrderByScoreAndNameASC(Map<String, Integer> friendScore) {
        List<String> recommandFriends = new ArrayList<>();

        Iterator<String> iterator = friendScore.keySet().iterator();
        while (iterator.hasNext()) {
            recommandFriends.add(iterator.next());
        }

        recommandFriends.sort((a, b) -> {
            if (friendScore.get(a) == friendScore.get(b)) {
                return a.compareTo(b);
            }

            return friendScore.get(a) < friendScore.get(b) ? 1 : -1;
        });

        return recommandFriends;
    }
}
