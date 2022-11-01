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

    public void addVisitLog(String user, List<String> visitors) {
        HashMap<String, Integer> visitLog = visitHistory.getOrDefault(user, new HashMap<>());
        for (String visitor : visitors) {
            enrollMember(visitor);
            visitLog.put(visitor, visitLog.getOrDefault(visitor, 0) + 1);
        }
        visitHistory.put(user, visitLog);
    }

    public List<String> recommendMembers(String user) {
        HashMap<String, Integer> recommendMap = new HashMap<>();

        updateRecommendMap(user, recommendMap);
        return recommendMembersUsingMap(recommendMap);
    }

    private List<String> recommendMembersUsingMap(HashMap<String, Integer> recommendMap) {
        PriorityQueue<RecommendedMember> recommendedMemberQueue = new PriorityQueue<>();
        for (String member : recommendMap.keySet()) {
            int score = recommendMap.get(member);
            recommendedMemberQueue.add(new RecommendedMember(member, score));
        }
        return extractFiveMember(recommendedMemberQueue);
    }

    private List<String> extractFiveMember(PriorityQueue<RecommendedMember> memberQueue) {
        List<String> list = new ArrayList<>();
        while (!memberQueue.isEmpty() && list.size() < RECOMMEND_NUMBER) {
            extractMemberToList(memberQueue, list);
        }
        return list;
    }

    private static void extractMemberToList(PriorityQueue<RecommendedMember> memberQueue, List<String> list) {
        RecommendedMember recommendedMember = memberQueue.poll();
        assert recommendedMember != null;
        if (recommendedMember.score > 0) {
            list.add(recommendedMember.name);
        }
    }

    private void updateRecommendMap(String user, HashMap<String, Integer> recommendMap) {
        List<String> membersNotFriendWithUser = findMembersNotFriendWith(user);

        updateRecommendMapUsingFriendShip(recommendMap, user, membersNotFriendWithUser);
        updateRecommendMapUsingVisitLog(recommendMap, user, membersNotFriendWithUser);
    }

    private void updateRecommendMapUsingFriendShip(HashMap<String, Integer> recommendMap, String user, List<String> membersNotFriendWithUser) {
        HashSet<String> usersFriends = friendShip.getOrDefault(user, new HashSet<>());
        for (String member : membersNotFriendWithUser) {
            int numOfMemberKnowTogether = 0;
            HashSet<String> membersFriends = friendShip.getOrDefault(member, new HashSet<>());
            for (String memberFriend : membersFriends) {
                if (usersFriends.contains(memberFriend)) {
                    numOfMemberKnowTogether++;
                }
            }
            recommendMap.put(member, recommendMap.getOrDefault(member, 0) + (numOfMemberKnowTogether * 10));
        }
    }

    private void updateRecommendMapUsingVisitLog(HashMap<String, Integer> recommendMap, String user, List<String> membersNotFriendWithUser) {
        HashMap<String, Integer> visitHistoryMap = visitHistory.getOrDefault(user, new HashMap<>());
        for (String member : membersNotFriendWithUser) {
            int numsOfVisit = visitHistoryMap.getOrDefault(member, 0);
            recommendMap.put(member, recommendMap.getOrDefault(member, 0) + numsOfVisit);
        }
    }

    private List<String> findMembersNotFriendWith(String user) {
        ArrayList<String> members = new ArrayList<>();
        HashSet<String> userFriendsSet = friendShip.getOrDefault(user, new HashSet<>());
        for (String member : memberSet) {
            if (!userFriendsSet.contains(member) && !member.equals(user)) members.add(member);
        }
        return members;
    }

    private void enrollMember(String member) {
        memberSet.add(member);
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
