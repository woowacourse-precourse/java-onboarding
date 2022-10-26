package onboarding.problem7.domain;

import java.util.Objects;

public class User {
    private final Friends friends;
    private Score score;
    
    public User() {
        this(new Friends());
    }
    
    public User(final Friends friends) {
        this.friends = friends;
        this.score = new Score();
    }
    
    public void addFriend(final String friend) {
        friends.add(friend);
    }
    
    public Friends getFriends() {
        return friends;
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
