package onboarding.prob7.domain;

public class User implements Comparable{
    private String name;
    private int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        User o1 = (User) o;
        if (this.score - o1.getScore() == 0) {
            return this.name.compareTo(o1.getName());
        }
        return o1.getScore()-this.score;
    }
}
