package onboarding.problem7.wrapper;

public class Friend {
    private final User userA;
    private final User userB;

    public Friend(User userA, User userB) {
        this.userA = userA;
        this.userB = userB;
    }

    public boolean contains(User user) {
        return userA.equals(user) || userB.equals(user);
    }
}
