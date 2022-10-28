package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        Map<String, User> userDataBase = new HashMap<>();

        for (List<String> friendList : friends) {
            User friend0 = getUserData(userDataBase, friendList.get(0));
            User friend1 = getUserData(userDataBase, friendList.get(1));

        }
        return answer;
    }

    private static User getUserData(Map<String, User> userDataBase, String userName) {
        User tempUser = userDataBase.get(userName);
        if (tempUser == null) {
            userDataBase.put(userName, new User(userName, 0));
        }

        return userDataBase.get(userName);
    }
    static class User implements Comparable<User> {
        private String name;
        private int recommendScore;
        private List<User> friendList = new ArrayList<>();

        public User(String name, int recommendScore) {
            this.name = name;
            this.recommendScore = recommendScore;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<User> getFriendList() {
            return friendList;
        }

        public int getRecommendScore() {
            return recommendScore;
        }

        public void setRecommendScore(int recommendScore) {
            this.recommendScore = recommendScore;
        }

        public void addRecommendScoreByFriendship() {
            if (this.recommendScore < 0) {
                return;
            }

            this.recommendScore += 10;
        }

        public void addRecommendScoreByVisitors() {
            if (this.recommendScore < 0) {
                return;
            }

            this.recommendScore += 1;
        }

        public void setFriendState() {
            this.recommendScore = -1;
        }

        @Override
        public int compareTo(User u) {
            if (this.getRecommendScore() > u.getRecommendScore()) {
                return -1;
            } else if (this.getRecommendScore() < u.getRecommendScore()) {
                return 1;
            } else {
                return this.getName().compareTo(u.getName());
            }
        }
    }
}
