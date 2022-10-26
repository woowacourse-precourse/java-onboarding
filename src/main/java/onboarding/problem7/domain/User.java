package onboarding.problem7.domain;

import java.util.Objects;

public class User {
    private final UserName userName;
    private final Friends friends;
    
    public User(final String userName) {
        this(new UserName(userName), new Friends());
    }
    
    public User(final UserName userName, final Friends friends) {
        this.userName = userName;
        this.friends = friends;
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
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(friends, user.friends);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userName, friends);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userName=" + userName +
                ", friends=" + friends +
                '}';
    }
}
