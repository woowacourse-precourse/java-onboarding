package onboarding.domain;

import java.util.Comparator;

public class Score {
    private int score;
    public String name;

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public final static Comparator<Score> comparator = (p1, p2) -> {
        if (p2.score != p1.score) {
            return p2.score - p1.score;
        } else {
            return p1.name.compareTo(p2.name);
        }
    };
}
