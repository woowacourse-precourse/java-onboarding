package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class FriendRecommender{
    private String user;
    private Map<String, Integer> recommendationScores = new HashMap<>();

    private FriendRecommender(Builder builder){
        this.user = builder.user;
        addFriendScore(builder.friends);

    }

    private void addFriendScore(Map<String, List<String>> friends){
        List<String> friendsOfUser = friends.get(user);
        final Integer recommendedFriendScore = 10;

        for (String friend : friendsOfUser){
            for(String recommendedFriend : friends.get(friend)){
                recommendationScores.put(recommendedFriend,
                        recommendationScores.getOrDefault(recommendedFriend, 0)
                                + recommendedFriendScore);
            }
        }
    }

    private void addVisitorScore(List<String> visitors){
        final Integer visitorScore = 1;
        for (String visitor : visitors){
            recommendationScores.put(visitor,
                    recommendationScores.getOrDefault(visitor, 0)
                            + visitorScore);
        }
    }




    public static class Builder {

        private String user;
        private Map<String, List<String>> friends;
        private List<String> visitors;

        public Builder(){
        }

        public Builder user(String user){
            this.user = user;
            return this;
        }

        public Builder friends(List<List<String>> friends){
            this.friends = toMap(friends);
            return this;
        }

        public Builder visitors(List<String> visitors){
            this.visitors = visitors;
            return this;
        }

        public FriendRecommender build() {
            return new FriendRecommender(this);
        }

        private static Map<String, List<String>>toMap(List<List<String>> linkedNodes){
            Map<String, List<String>> linkedMap = new HashMap<>();

            for (List<String> linkedNode: linkedNodes){
                String nodeA =  linkedNode.get(0);
                String nodeB =  linkedNode.get(1);

                List<String> nodesLinkedToA= linkedMap.getOrDefault(
                        nodeA, new ArrayList<>());
                List<String> nodesLinkedToB = linkedMap.getOrDefault(
                        nodeB, new ArrayList<>());

                nodesLinkedToA.add(nodeB);
                nodesLinkedToB.add(nodeA);

                linkedMap.put(nodeA, nodesLinkedToA);
                linkedMap.put(nodeB, nodesLinkedToB);
            }

            return linkedMap;
        }
    }






}
