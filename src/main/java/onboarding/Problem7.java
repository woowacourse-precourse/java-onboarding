package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendsOfCrews = new HashMap<>();
        Map<String, Integer> cntVisitMap = new HashMap<>();
        Map<String, Integer> friendScore = new HashMap<>();

        List<Crew> result = new ArrayList<>();

        for (List<String> friend : friends) {
            String crewA = friend.get(0);
            String crewB = friend.get(1);
            networking(crewA, crewB, friendsOfCrews);
        }
        cntMyTimeLineVisitor(visitors, cntVisitMap);
        calculateFriendScore(user, friendsOfCrews, cntVisitMap, friendScore);

        Set<String> userFriends = friendsOfCrews.get(user);
        for (String friend : friendScore.keySet()) {
            int score = friendScore.get(friend);
            if (score > 0 && !userFriends.contains(friend)) {
                result.add(new Crew(friend, score));
            }
        }

        result.sort((crew1, crew2) -> crew1.score != crew2.score ? crew2.score - crew1.score : crew1.name.compareTo(crew2.name));

        List<String> returnList = result.stream().map((crew -> crew.name)).collect(Collectors.toList());
        return returnList.size() > 5 ? returnList.subList(0, 5) : returnList;
    }

    private static void networking(String crewA, String crewB, Map<String, Set<String>> friendsOfCrews) {
        if (!friendsOfCrews.containsKey(crewA)) {
            friendsOfCrews.put(crewA, new HashSet<>());
        }
        friendsOfCrews.get(crewA).add(crewB);

        if (!friendsOfCrews.containsKey(crewB)) {
            friendsOfCrews.put(crewB, new HashSet<>());
        }
        friendsOfCrews.get(crewB).add(crewA);
    }

    private static void cntMyTimeLineVisitor(List<String> visitors, Map<String, Integer> cntVisit) {
        for (String visitor : visitors) {
            if (!cntVisit.containsKey(visitor)) {
                cntVisit.put(visitor, 0);
            }
            cntVisit.put(visitor, cntVisit.get(visitor) + 1);
        }
    }

    private static void calculateFriendScore(String user, Map<String, Set<String>> friendsOfCrews, Map<String, Integer> cntVisitMap, Map<String, Integer> friendScore) {
        if (friendsOfCrews.containsKey(user)) {
            Set<String> userFriends = friendsOfCrews.get(user);
            for (String crewName : friendsOfCrews.keySet()) {
                if (crewName.equals(user)) continue;
                Set<String> commonFriends = new HashSet<>(friendsOfCrews.get(crewName));
                commonFriends.retainAll(userFriends);
                friendScore.put(crewName, commonFriends.size() * 10);
            }
        }

        for (String visitor :
                cntVisitMap.keySet()) {
            int cntVisit = cntVisitMap.get(visitor);
            if (!friendScore.containsKey(visitor)) {
                friendScore.put(visitor, 0);
            }
            friendScore.put(visitor, friendScore.get(visitor) + cntVisit);
        }
    }

    static class Crew {
        String name;
        int score;

        public Crew(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
