package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, HashSet<String>> friendsMap = new HashMap<String, HashSet<String>>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> relation = friends.get(i);

            String member1 = relation.get(0);
            String member2 = relation.get(1);

            makeFriendsMap(friendsMap, member1, member2);
            makeFriendsMap(friendsMap, member2, member1);
        }

        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashSet<String> userDirectFriendsSet;

        if (friendsMap.get(user) == null) {
            userDirectFriendsSet = new HashSet<>();
        } else {
            userDirectFriendsSet = friendsMap.get(user);
        }

        for (String userDirectFriend : userDirectFriendsSet) {
            HashSet<String> memberSet = friendsMap.get(userDirectFriend);

            checkMemberSet(memberSet, user, friendsMap, scoreMap);
        }

        return answer;
    }

    private static void makeFriendsMap(HashMap<String, HashSet<String>> friendsMap, String member1, String member2) {
        if (friendsMap.containsKey(member1)) {
            HashSet<String> set = friendsMap.get(member1);
            set.add(member2);
            friendsMap.put(member1, set);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(member2);
            friendsMap.put(member1, set);
        }
    }

    private static void checkMemberSet(HashSet<String> memberSet, String user, HashMap<String, HashSet<String>> friendsMap, HashMap<String, Integer> scoreMap) {
        for (String member : memberSet) {
            if (member.equals(user)) {
                continue;
            }

            HashSet<String> anotherMemberSet = friendsMap.get(member);

            boolean anotherMemberKnowsUser = whetherAnotherMemberKnowsUser(anotherMemberSet, user);

            if (!anotherMemberKnowsUser) {
                addScoreIntoScoreMap(scoreMap, member);
            }
        }
    }

    private static boolean whetherAnotherMemberKnowsUser(HashSet<String> anotherMemberSet, String user) {
        for (String anotherMember : anotherMemberSet) {
            if (anotherMember.equals(user)) {
                return true;
            }
        }
        return false;
    }

    private static void addScoreIntoScoreMap(HashMap<String, Integer> scoreMap, String member) {
        if (scoreMap.containsKey(member)) {
            scoreMap.put(member, scoreMap.get(member) + 10);
        } else {
            scoreMap.put(member, 10);
        }
    }
}
