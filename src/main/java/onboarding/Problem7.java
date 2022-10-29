package onboarding;

import java.util.Collections;
import java.util.List;

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
                for(String secondFriend : relationship.get(friend)){
                    if(!secondFriend.equals(user)){
                        recommendationScore.put(secondFriend, recommendationScore.getOrDefault(secondFriend,0)+10);
                    }
                }
                //relationship.get(friend).stream().filter(i->!i.equals(user)).map(i->recommendationScore.put(i,recommendationScore.getOrDefault(i,0)+10));
                recommendationScore.remove(friend);
            }
        }

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
