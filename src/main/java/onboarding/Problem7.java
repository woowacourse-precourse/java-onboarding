package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = new HashSet<>();
        friends.forEach(elem -> getFriendsInSet(userFriends, user, elem.get(0), elem.get(1)));
    }

    private static void getFriendsInSet(Set<String> setFriends, String user, String friendA, String friendB) {
        if (friendA.equals(user)) {
            setFriends.add(friendB);
        }
        if (friendA.equals(user)) {
            setFriends.add(friendB);
        }
    }
}

//A
//
//B C D
//
//각 B C D의 친구들 다 list에 넣어서 elem마다 점수 10점씩 주는데
//이때 elem이 A와 친구 set에 있으면 안주고 아니면 줌.