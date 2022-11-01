package onboarding.p7;

import java.util.Objects;

public class RecommendUser {
    private final String name;
    private int score;

    public RecommendUser(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void plusScore(int score) {
        this.score += score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendUser that = (RecommendUser) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
