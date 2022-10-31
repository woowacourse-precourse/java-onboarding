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
            for(String v : visitors) {
                Integer score = recommendationScore.getOrDefault(v, 0);
                recommendationScore.put(v, score+1);
            }
        }

        public void addFriendScore() {
            List<String> userFriendList = relationship.get(user);      // user의 1차 친구리스트

            for(String firstFriend : userFriendList){
                for(String secondFriend : relationship.get(firstFriend)){
                    if(!secondFriend.equals(user)){
                        recommendationScore.put(secondFriend, recommendationScore.getOrDefault(secondFriend,0)+10);
                    }
                }
                recommendationScore.remove(firstFriend);
            }
        }

        void makeRelationship(List<List<String>> friendList) {
            for(List<String> friends : friendList){
               addOnRelationship(friends);
            }
        }

        private void addOnRelationship(List<String> friends) {
            for(int i=0 ; i<2 ; i++) {
                List<String> list = relationship.getOrDefault(friends.get(i), new ArrayList<>());
                int j = (i==0)? 1 : 0;
                list.add(friends.get(j));
                relationship.put(friends.get(i), list);
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
