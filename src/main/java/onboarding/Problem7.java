package onboarding;

import java.util.*;

public class Problem7 {
    static class RecommendAlgorithm {
        List<String> userKnownMembers = new ArrayList<>();
        List<List<String>> userUnknownMembers = new ArrayList<>();
        Map<String, Integer> membersScore = new HashMap<>();
        String user;

        public void setUser(String user) {
            this.user = user;
        }


        // 1번
        public void checkUserFriends (List<List<String>> friends){
            for (List<String> friend : friends) {
                if (friend.contains(user)) {
                    friend.stream()
                            .filter(f -> !f.equals(user))
                            .forEach(x -> userKnownMembers.add(x));
                }
                else {
                    userUnknownMembers.add(friend);
                }
            }
            for (String friend : userKnownMembers) {
                for (List<String> friendship : userUnknownMembers) {
                    if (friendship.contains(friend)) {
                        friendship.stream()
                                .filter(f -> !f.equals(friend))
                                .forEach(x -> setScore(x, "friends"));
                    }
                }
            }
        }
        public void setScore (String member, String category) {
            if (category == "friends") {
                if (membersScore.containsKey(member)) {
                    membersScore.put(member, membersScore.get(member) + 10);
                } else {
                    membersScore.put(member, 10);
                }
            } else {
                if (membersScore.containsKey(member)) {
                    membersScore.put(member, membersScore.get(member) + 1);
                } else {
                    membersScore.put(member, 1);
                }
            }
        }

        // 2번 visitor
        public void checkVisitors (List<String> visitors) {
            visitors.stream()
                    .filter(x -> !userKnownMembers.contains(x))
                    .forEach(x -> setScore(x, "visitors"));
        }

        public List<String> memberSort (Map<String, Integer> score) {
            List<String> result = new ArrayList<>(score.keySet());

            Collections.sort(result, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return score.get(o2).compareTo(score.get(o1));
                }
            });

            return result;
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        RecommendAlgorithm recommendAlgorithm = new RecommendAlgorithm();
        recommendAlgorithm.setUser(user);

        recommendAlgorithm.checkUserFriends(friends);
        recommendAlgorithm.checkVisitors(visitors);

        List<String> answer = recommendAlgorithm.memberSort(recommendAlgorithm.membersScore);

        return answer;
    }

}
