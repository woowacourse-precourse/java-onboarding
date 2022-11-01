package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> usersFriends = new ArrayList<>();
        List<String> friendOfFriend = new ArrayList<>();
        List<Friend> recommended = new ArrayList<>();
        List<String> answer = new ArrayList<>();

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

        friendOfFriend.sort(Comparator.naturalOrder());
        String before = "";
        int score = 0;
        for (String name : friendOfFriend) {
            if (name.equals(user)) {
                continue;
            }
            if (!before.equals(name)) {
                recommended.add(new Friend(before, score));
                before = name;
                score = 10;
            } else {
                score += 10;
            }
        }
        recommended.remove(0);
        recommended.add(new Friend(before, score));

        for (String visitor : visitors) {
            if (usersFriends.contains(visitor)) {
                continue;
            }
            boolean appended = false;
            for (Friend info : recommended) {
                if (info.getName().equals(visitor)) {
                    info.setScore(info.getScore() + 1);
                    appended = true;
                }
            }
            if (!appended) {
                recommended.add(new Friend(visitor, 1));
            }
        }

        Collections.sort(recommended);
        for (Friend info : recommended) {
            if (answer.size() > 5) {
                break;
            }
            answer.add(info.getName());
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