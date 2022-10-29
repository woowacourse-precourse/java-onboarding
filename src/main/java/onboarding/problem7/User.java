package onboarding.problem7;

public class User {

    private String name;
    private int visits;
    private boolean isFriends = false;

    public User(String name, int visits, boolean isFriends) {
        this.name = name;
        this.visits = visits;
        this.isFriends = isFriends;
    }
}
