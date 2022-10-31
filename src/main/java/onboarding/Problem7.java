package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

    static class RecommendScore implements Comparable<RecommendScore> {
        String id;
        int score;

        public RecommendScore(String id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(RecommendScore o) {
            int compare1 = Integer.compare(o.score, score);
            if (compare1 == 0) {
                return id.compareTo(o.id);
            }
            return compare1;
        }
    }

    static HashMap<String, List<String>> friendList = new HashMap<>();

    static HashMap<String, Integer> recommendScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        for (List<String> friend : friends) {
            saveFriendById(friend.get(0), friend.get(1));
        }

        saveFriendScoreByUser(user);

        for (String visitor : visitors) {
            saveVisitScore(visitor);
        }

        System.out.println("recommendScore = " + recommendScore.toString());
        List<RecommendScore> scoreList = new ArrayList<>();

        int score;
        for (String id : recommendScore.keySet()) {

            if (friendList.get(user).contains(id)) {
                continue;
            }

            score = recommendScore.get(id);

            if (score > 0) {
                scoreList.add(new RecommendScore(id, score));
            }
        }

        Collections.sort(scoreList);

        List<String> answer = new ArrayList<>();
        int size = Math.min(scoreList.size(), 5);

        for (int i = 0; i < size; i++) {
            answer.add(scoreList.get(i).id);
        }

        return answer;
    }

    //각 아이디의 친구인 관계를 저장
    static void saveFriendById(String idA, String idB) {

        if (friendList.get(idA) == null) {
            ArrayList<String> list = new ArrayList<>();
            list.add(idB);
            friendList.put(idA, list);

        } else {
            friendList.get(idA).add(idB);
        }
        if (friendList.get(idB) == null) {
            ArrayList<String> list = new ArrayList<>();
            list.add(idA);
            friendList.put(idB, list);

        } else {
            friendList.get(idB).add(idA);
        }
    }

    //사용자와 함께 아는 친구 수의 점수 저장
    static void saveFriendScoreByUser(String user) {

        int score;

        if (friendList.get(user) == null) {
            return;
        }

        for (String id : friendList.keySet()) {
            if (id.equals(user)) {
                continue;
            }

            ArrayList<String> friend = new ArrayList<>(friendList.get(id));

            friend.retainAll(friendList.get(user));
            score = friend.size() * 10;

            if (recommendScore.get(id) == null) {
                recommendScore.put(id, score);

            } else {
                recommendScore.put(id, recommendScore.get(id) + score);
            }

        }

    }

    //방문한 횟수의 점수 저장
    static void saveVisitScore(String id) {

        int score = 1;

        if (recommendScore.get(id) == null) {
            recommendScore.put(id, score);

        } else {
            recommendScore.put(id, recommendScore.get(id) + score);
        }

    }
}
