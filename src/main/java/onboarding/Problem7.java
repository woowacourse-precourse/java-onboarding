package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem7 {

    public static class FriendRecommendation {
        String name;
        int score;

        public FriendRecommendation(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static HashSet<String> getFriendList(String user, List<List<String>> friends) {
        HashSet<String> alreadyFriends = new HashSet<>();

        for (int i = 0; i < friends.size(); i++) { // alreadyFriend 에 친구를 찾아내는 과정
            List<String> info = friends.get(i);

            if (info.get(0).equals(user) || info.get(1).equals(user)) { // user 의 친구이면 Friend 에 등록한다.
                alreadyFriends.add(info.get(0).equals(user) ? info.get(1) : info.get(0));
            }
        }

        return alreadyFriends;
    }

    public static HashMap<String, Integer> getScoreList(List<List<String>> friends, List<String> visitors, HashSet<String> alreadyFriends) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            List<String> info = friends.get(i);

            if (alreadyFriends.contains(info.get(0)) || alreadyFriends.contains(info.get(1))) { // 실친이 있으면 둘다 + 10 해준다, 왜 이렇게 해도 되는지는 나중에 실친, 유저는 제거해줄 것이기 떄문이다.
                if (scoreBoard.containsKey(info.get(0))) {
                    int score = scoreBoard.get(info.get(0));
                    score += 10;
                    scoreBoard.put(info.get(0), score);
                } else {
                    scoreBoard.put(info.get(0), 10);
                }

                if (scoreBoard.containsKey(info.get(1))) {
                    int score = scoreBoard.get(info.get(1));
                    score += 10;
                    scoreBoard.put(info.get(1), score);
                } else {
                    scoreBoard.put(info.get(1), 10);
                }
            }
        } // 점수는 해결 완료

        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);

            if (scoreBoard.containsKey(name)) {
                int score = scoreBoard.get(name);
                score++;
                scoreBoard.put(name, score);
            } else {
                scoreBoard.put(name, 1);
            }
        }

        return scoreBoard;
    }

    public static List<String> getRecommendationList(String user, HashSet<String> alreadyFriends, HashMap<String, Integer> scoreBoard) {
        List<FriendRecommendation> recommendations = new ArrayList<>();

        for (String key : scoreBoard.keySet()) {
            int score = scoreBoard.get(key);
            recommendations.add(new FriendRecommendation(key, score));
        }

        Collections.sort(recommendations, (o1, o2) -> o1.name.compareTo(o2.name));
        Collections.sort(recommendations, (o1, o2) -> o2.score - o1.score);
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < recommendations.size(); i++) {
            FriendRecommendation info = recommendations.get(i);

            if (!(alreadyFriends.contains(info.name) || user.equals(info.name))) { // 실친이나, User 가 아닌 경우에만
                if (info.score == 0) {
                    break;
                } else {
                    answer.add(info.name);
                }
            }

            if (answer.size() == 5) {
                break;
            }
        }

        return answer;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> alreadyFriends = getFriendList(user, friends);
        HashMap<String, Integer> scoreBoard = getScoreList(friends, visitors, alreadyFriends);

        return getRecommendationList(user, alreadyFriends, scoreBoard);
    }
}
