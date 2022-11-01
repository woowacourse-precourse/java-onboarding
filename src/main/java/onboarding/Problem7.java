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
     * 친구의 친구의 추천 점수 구하기
     * @param friendsFriends
     * @return List<FriendsFriends>
     */
    private static List<FriendsFriends> scoreFriends(List<String> friendsFriends) {
        List<FriendsFriends> scoreList = new ArrayList<>();

        for (int i = 0; i < friendsFriends.size() - 1; i++) {
            int score = 1;
            for (int j = i + 1; j < friendsFriends.size(); j++) {
                if (friendsFriends.get(i).equals(friendsFriends.get(j))) {
                    score++;
                } else {
                    continue;
                }
                scoreList.add(new FriendsFriends(friendsFriends.get(i), score * 10));
            }
        }
        return scoreList;
    }

    /**
     * 친구의 친구 찾기
     * @param userFriends
     * @param friends
     * @param user
     * @return List<String>
     */
    private static List<String> findFriendsFriends(List<String> userFriends, List<List<String>> friends, String user) {
        List<String> friendsFriends = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < userFriends.size(); j++) {
                if (friends.get(i).contains(userFriends.get(j))) {
                    for (int k = 0; k < friends.get(i).size(); k++) {
                        if (!friends.get(i).get(k).equals(userFriends.get(j)) && !friends.get(i).get(k).equals(user)) {
                            friendsFriends.add(friends.get(i).get(k));
                        }
                    }
                }
            }
        }
        return friendsFriends;
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
