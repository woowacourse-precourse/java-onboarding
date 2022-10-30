package onboarding.problem7;


import java.util.Objects;

public class User {
    private String name;
    private int score;
    public User(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean isNotZeroScore() {
        return this.score != 0;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}