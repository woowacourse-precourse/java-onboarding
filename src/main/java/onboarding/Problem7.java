package onboarding;


import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<userScore> score = new ArrayList<>();
        score.add(new userScore(user, -1));
        for (List<String> friend : friends) {
            for (String s : friend) {
                if (!(score.stream().map(u -> u.name).collect(Collectors.toList())).contains(s)) {
                    score.add(new userScore(s, 0));
                }
            }
        }
        for (String visitor : visitors) {
            if (!(score.stream().map(u -> u.name).collect(Collectors.toList())).contains(visitor)) {
                score.add(new userScore(visitor, 0));
            }
        }

        for (String visitor : visitors) {
            for (int i = 0; i < score.size(); i++) {
                if (visitor.equals(score.get(i).name)) {
                    score.get(i).score++;
                }
            }
        }

        boolean[][] relations = new boolean[score.size()][score.size()];
        List<Integer> userFriend = new ArrayList<>();
        for (List<String> friend : friends) {
            int first = score.stream().map(u -> u.name).collect(Collectors.toList()).indexOf(friend.get(0));
            int second = score.stream().map(u -> u.name).collect(Collectors.toList()).indexOf(friend.get(1));
            relations[first][second] = relations[second][first] = true;
            if (friend.get(0).equals(user)) {
                userFriend.add(second);
            } else if (friend.get(1).equals(user)) {
                userFriend.add(first);
            }
        }

        for (int i = 1; i < score.size(); i++) {
            for (Integer integer : userFriend) {
                if (relations[i][integer]) {
                    score.get(i).score += 10;
                }
            }
        }
        score.sort(((o1, o2) -> {if (o1.score == o2.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o2.score - o1.score;
        }}));

        for (int i = 0; i < 3; i++) {
            answer.add(score.get(i).name);
        }
        return answer;
    }

    private static class userScore{
        String name;
        int score;

        public userScore(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

}
