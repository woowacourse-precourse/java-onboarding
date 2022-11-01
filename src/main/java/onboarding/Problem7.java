package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> friendCandidateHashMap = new HashMap<>();
        setFriendScoreOfUser(friendCandidateHashMap, friends, user);
        setVisitorScoreOfUser(friendCandidateHashMap, friends, visitors, user);


        return answer;
    }

    private static void setFriendScoreOfUser(HashMap<String, Integer> friendCandidateHashMap, List<List<String>> friends, String user) {
        List<String> friendsOfUser = getFriendOfUser(friends, user);
        List<String> friendsOfFriendOfUser = getFriendOfFriendOfUser(friendsOfUser, friends, user);
        for (String friendOfFriendOfUser : friendsOfFriendOfUser) {
            friendCandidateHashMap.put(friendOfFriendOfUser, friendCandidateHashMap.containsKey("friendOfFriendOfUser") ? friendCandidateHashMap.get(friendOfFriendOfUser) + 10 : 10);
        }
    }

    private static List<String> getFriendOfUser(List<List<String>> friends, String user) {
        List<String> friendOfUser = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                friendOfUser.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                friendOfUser.add(friend.get(0));
            }
        }
        return friendOfUser;
    }

    private static List<String> getFriendOfFriendOfUser(List<String> friendsOfUser, List<List<String>> friends, String user) {
        List<String> friendsOfFriendOfUser = new ArrayList<>();
        for (String friendOfUser : friendsOfUser) {
            for (List<String> friend : friends) {
                if (friend.get(0).equals(friendOfUser) && !friend.get(1).equals(user)) {
                    friendsOfFriendOfUser.add(friend.get(1));
                }
                else if (friend.get(1).equals(friendOfUser) && !friend.get(0).equals(user)) {
                    friendsOfFriendOfUser.add(friend.get(0));
                }
            }
        }
        return friendsOfFriendOfUser;
    }

    private static void setVisitorScoreOfUser(HashMap<String, Integer> friendCandidateHashMap, List<List<String>> friends, List<String> visitors, String user) {
        List<String> friendsOfUser = getFriendOfUser(friends, user);
        HashSet<String> visitorsExceptFriend = getVisitorsExceptFriend(visitors, friendsOfUser);
        for (String visitorExceptFriend : visitorsExceptFriend) {
            friendCandidateHashMap.put(visitorExceptFriend, friendCandidateHashMap.containsKey(visitorExceptFriend) ? friendCandidateHashMap.get(visitorExceptFriend) + 1 : 1);
        }
    }

    private static HashSet<String> getVisitorsExceptFriend(List<String> visitors, List<String> friendsOfUser) {

    }
}
