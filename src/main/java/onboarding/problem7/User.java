package onboarding.problem7;

public class User {

    private String name;
    private int visits = 0;

    public User(String name) {
        this.name = name;
    }

    public int getVisits() {
        return this.visits;
    }

    public String getName() {
        return this.name;
    }

    public void addVisits() {
        this.visits += 1;
    }
}
