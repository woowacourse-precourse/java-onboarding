package onboarding;

import java.util.*;

public class Problem7 {
    static class FriendsFriends {
        private String friendsFriends;
        private int score;

        public FriendsFriends(String friendsFriends, int score) {
            this.friendsFriends = friendsFriends;
            this.score = score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = findFriends(user, friends);
        List<String> friendsFriends = findFriendsFriends(userFriends, friends, user);
        List<FriendsFriends> scoreList = scoreFriends(friendsFriends);
        List<String> visitorsNotFriends = visitorsScore(visitors, userFriends);
        scoreList = wholeScore(scoreList, visitorsNotFriends);
        List<String> sortedRecommend = sortRecommend(scoreList);
        return sortedRecommend;
    }

    /**
     * 사용자의 친구 찾기
     * @param user
     * @param friends
     * @return List<String>
     */
    private static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).contains(user)) {
                for (int j = 0; j < friends.get(i).size(); j++) {
                    if (!friends.get(i).get(j).equals(user)) {
                        userFriends.add(friends.get(i).get(j));
                    }
                }
            }
        }
        return userFriends;
    }
}
