package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> friendsList;
    public static Map<String, Integer> recommendScore;
    public static Map<String, List<String>> relationships;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<UserInfo> answerList = new ArrayList<>();
        friendsList = new ArrayList<>();
        recommendScore = new HashMap<>();
        relationships = new HashMap<>();
        for (List<String> friend : friends) {
            initFriendsList(friend, user);
            initRelationships(friend,user);
        }
        List<String> userFriendList = friendsList.stream()
                .distinct()
                .collect(Collectors.toList());

        for (String username : userFriendList) {
            relationships.get(username)
                    .forEach(x -> addRecommendScore(x,10));
        }

        visitors.forEach(x -> addRecommendScore(x,1));


        recommendScore.entrySet().stream()
                .filter(x -> !userFriendList.contains(x.getKey()))
                .forEach(x -> answerList.add(new UserInfo(x.getKey(),x.getValue())));


        return answerList.stream()
                .sorted(Comparator.comparing(UserInfo::getScore, Comparator.reverseOrder())
                        .thenComparing(UserInfo::getUsername))
                .map(UserInfo::getUsername)
                .collect(Collectors.toList());
    }

    public static void initFriendsList(List<String> relationship, String user) {
        String userA = relationship.get(0);
        String userB = relationship.get(1);

        if(userA.equals(user)){
            friendsList.add(userB);
            return;
        }
        friendsList.add(userA);
    }

    public static void initRelationships(List<String> relationship,String user) {
        String userA = relationship.get(0);
        String userB = relationship.get(1);

        if (userA.equals(user) || userB.equals(user)) {
            return;
        }

        addRelationships(userA,userB);
        addRelationships(userB,userA);
    }

    public static void addRelationships(String userA, String userB) {
        if(relationships.containsKey(userA)){
            relationships.get(userA).add(userB);
            return;
        }
        relationships.put(userA, new ArrayList<>(List.of(userB)));
    }

    public static void addRecommendScore(String username, int score) {
        if (recommendScore.containsKey(username)) {
            recommendScore.put(username, recommendScore.get(username) + score);
            return;
        }
        recommendScore.put(username,score);
    }

    static class UserInfo{
        String username;
        int score;

        public UserInfo(String username, int score) {
            this.username = username;
            this.score = score;
        }

        public String getUsername() {
            return username;
        }

        public int getScore() {
            return score;
        }
    }
}
