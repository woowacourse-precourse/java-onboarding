package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
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