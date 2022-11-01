package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> usersFriends = new ArrayList<>();
        List<String> friendOfFriend = new ArrayList<>();
        List<String> answer = Collections.emptyList();

        for (List<String> relations : friends) {
            if (user.equals(relations.get(0))) {
                usersFriends.add(relations.get(1));
            } else if (user.equals(relations.get(1))) {
                usersFriends.add(relations.get(0));
            }
        }
        for (String friendName : usersFriends) {
            for (List<String> relations : friends) {
                if (friendName.equals(relations.get(0))) {
                    friendOfFriend.add(relations.get(1));
                } else if (friendName.equals(relations.get(1))) {
                    friendOfFriend.add(relations.get(0));
                }
            }
        }

        return answer;
    }
}
class Friend implements Comparable<Friend> {
    private String name;
    private int score;

    public Friend (String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public int compareTo(Friend f) {
        if (this.score < f.getScore()) {
            return 1;
        } else if (this.score > f.getScore()) {
            return -1;
        }
        return this.name.compareTo(f.getName());
    }
}