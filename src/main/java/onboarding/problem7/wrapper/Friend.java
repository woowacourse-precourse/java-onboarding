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

    public User getAnotherUserNot(User user) {
        if (userA.equals(user)) {
            return userB;
        }
        return userA;
    }

    public User getFriendOf(User user) {
        if (!contains(user)) {
            return null;
        }
        return getAnotherUserNot(user);
    }
}
