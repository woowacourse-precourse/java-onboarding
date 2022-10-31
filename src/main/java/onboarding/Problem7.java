package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = new HashSet<>();
        friends.forEach(elem -> updateFriendsInSet(userFriends, user, elem.get(0), elem.get(1)));

        List<String> friendsOfUserFriends = new ArrayList<>();
        userFriends.forEach(elem -> updateFriendsInList(elem, friendsOfUserFriends, friends));
    }

    private static void updateFriendsInSet(Set<String> setFriends, String target, String friendA, String friendB) {
        if (friendA.equals(target)) {
            setFriends.add(friendB);
        }
        if (friendB.equals(target)) {
            setFriends.add(friendA);
        }
    }

    private static void updateFriendsInList(String target, List<String> listFriends, List<List<String>> friends) {
        Set<String> targetFriends = new HashSet<>();
        friends.forEach(elem -> updateFriendsInSet(targetFriends, target, elem.get(0), elem.get(1)));
        targetFriends.forEach(elem -> listFriends.add(elem));
    }
}

//A
//
//B C D
//
//각 B C D의 친구들 다 list에 넣어서 elem마다 점수 10점씩 주는데
//이때 elem이 A와 친구 set에 있으면 안주고 아니면 줌.