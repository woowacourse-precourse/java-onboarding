package onboarding.problem7.domain;

import java.util.Objects;

public class User {
    private final String userName;
    private final Friends friends;
    private Score score;
    
    public User(String userName) {
        this(userName, new Friends());
    }
    
    public User(final String userName, final Friends friends) {
        this.userName = userName;
        this.friends = friends;
        this.score = new Score();
    }
    
    public void addFriend(final String friend) {
        friends.add(friend);
    }
    
    public int numberOfFriendsYouKnowTogether(final User user) {
        return friends.numberOfFriendsYouKnowTogether(user.friends);
    }
    
    public void addScoreOfNumberOfFriendsYouKnowTogether(final int numberOfFriendsYouKnowTogether) {
        this.score = score.addScoreOfNumberOfFriendsYouKnowTogether(numberOfFriendsYouKnowTogether);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "friends=" + friends +
                ", score=" + score +
                '}';
    }
}
