package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        FriendGraph friendGraph = new FriendGraph();

        for (List<String> friend : friends) {
            initUserScoreMap(scoreMap, friend.get(0));
            initUserScoreMap(scoreMap, friend.get(1));
            friendGraph.addFriend(friend.get(0),friend.get(1));
            friendGraph.addFriend(friend.get(1),friend.get(0));
        }

        List<String> userFriendList = friendGraph.getFriendList(user);
        updateScoreMapByUserFriendList(friendGraph, scoreMap, userFriendList);
        updateScoreMapByVisitorList(visitors, scoreMap);

        deleteScoreMapMemberByUserFriendList(user, scoreMap, userFriendList);

        return scoreMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o2.getValue())
                .map(i -> i.getKey())
                .limit(5)
                .collect(Collectors.toList());
    }


    static class Member {
        private String name;
        private Integer score;

        private List<String> friendList = new ArrayList<>();


        public Member(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public List<String> getFriendList() {
            return friendList;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

        public void changeScore(Integer score) {
            this.score = score;
        }

    }


    static class FriendGraph {
        private Map<String, List<String>> friendMap = new HashMap<>();

        public void addFriend(String user, String friend) {
            if (!friendMap.containsKey(user)) {
                friendMap.put(user,new ArrayList<>());
            }
            friendMap.get(user).add(friend);
        }

        public List<String> getFriendList(String user) {
            return friendMap.get(user);
        }

        public Iterator<String> getIteratorFriendGraph(){
            return friendMap.keySet().iterator();
        }

    }
    private static void initUserScoreMap(Map<String, Integer> scoreMap, String user) {
        if (!scoreMap.containsKey(user)) {
            scoreMap.put(user, 0);
        }
    }

    private static void updateScoreMapByUserFriendList(FriendGraph friendGraph,
                                                       Map<String, Integer> scoreMap,
                                                       List<String> userFriendList) {

        Iterator<String> friendMapList = friendGraph.getIteratorFriendGraph();
        for (String userFriend : userFriendList) {
            while (friendMapList.hasNext()) {
                String next = friendMapList.next();
                if (friendGraph.getFriendList(next).contains(userFriend)) {
                    scoreMap.put(next, scoreMap.get(next) + 10);
                }
            }
        }
    }
    private static void deleteScoreMapMemberByUserFriendList(String user, Map<String, Integer> scoreMap, List<String> userFriendList) {
        for (String userFriend : userFriendList) {
            scoreMap.remove(userFriend);
        }
        scoreMap.remove(user);
    }

    private static void updateScoreMapByVisitorList(List<String> visitors, Map<String, Integer> scoreMap) {
        for (String visitor : visitors) {
            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
            scoreMap.put(visitor, scoreMap.get(visitor) + 1);
        }
    }


}
