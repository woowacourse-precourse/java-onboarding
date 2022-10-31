package onboarding.problem7;

import java.util.*;

public class Sns {
    public static final int RECOMMEND_NUMBER = 5;

    public HashSet<String> memberSet = new HashSet<>();
    public HashMap<String, HashSet<String>> friendShip = new HashMap<>();
    public HashMap<String, HashMap<String, Integer>> visitHistory = new HashMap<>();

    public void setFriendShip(List<List<String>> friendships) {
        String memberA;
        String memberB;

        for (List<String> friend : friendships) {
            memberA = friend.get(0);
            memberB = friend.get(1);
            enrollMembers(List.of(memberA, memberB));
            makeFriendShip(memberA, memberB);
        }
    }

    private void enrollMembers(List<String> members) {
        memberSet.addAll(members);
    }

    private void makeFriendShip(String memberA, String memberB) {
        HashSet<String> friendShipOfA = friendShip.getOrDefault(memberA, new HashSet<>());
        HashSet<String> friendShipOfB = friendShip.getOrDefault(memberB, new HashSet<>());

        friendShipOfA.add(memberB);
        friendShipOfB.add(memberA);

        friendShip.put(memberA, friendShipOfA);
        friendShip.put(memberB, friendShipOfB);
    }
}
