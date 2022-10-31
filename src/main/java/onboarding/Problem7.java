package onboarding;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    static class SNS {
        private String user;
        private Map<String, List<String>> relationship = new HashMap<>();
        private Map<String,Integer> recommendationScore = new HashMap<>();

        public SNS(String user) {
            this.user = user;
        }

        public void addVisitorScore(List<String> visitors) {
            for(String visitor : visitors) {
                Integer orDefault = recommendationScore.getOrDefault(visitor, 0);
                recommendationScore.put(visitor, orDefault+1);
            }
        }

        public void addFriendScore() {
            List<String> userFriends = relationship.get(user);
            for(String friend : userFriends){
                for(String fof : relationship.get(friend)){
                    if(!fof.equals(user)){
                        recommendationScore.put(fof, recommendationScore.getOrDefault(fof,0)+10);
                    }
                }
                //relationship.get(friend).stream().filter(i->!i.equals(user)).map(i->recommendationScore.put(i,recommendationScore.getOrDefault(i,0)+10));
                recommendationScore.remove(friend);
            }
        }

        void makeRelationship(List<List<String>> friendList) {
            for(List<String> friends : friendList){
               addOnRelationship(friends);
            }
        }

        private void addOnRelationship(List<String> friends) {
            for(int i=0 ; i<2 ; i++) {
                List<String> p2Friends = relationship.getOrDefault(friends.get(i), new ArrayList<>());
                int j = (i==0)? 1 : 0;
                p2Friends.add(friends.get(j));
                relationship.put(friends.get(i), p2Friends);
            }
        }

        public List<String> getSortedResult() {
            List<Entry<String, Integer>> entries = new ArrayList<>(recommendationScore.entrySet());
            List<String> result = new ArrayList<>();

            entries.sort((o1, o2) -> recommendationScore.get(o2.getKey())-recommendationScore.get(o1.getKey()));    // 내림차순
            for(Entry<String,Integer> entry: entries) {
                result.add(entry.getKey());
            }
            return result;
        }

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SNS sns = new SNS(user);
        sns.makeRelationship(friends);
        sns.addVisitorScore(visitors);
        sns.addFriendScore();
        return sns.getSortedResult();
    }
}
