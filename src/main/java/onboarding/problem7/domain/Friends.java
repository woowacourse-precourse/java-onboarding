package onboarding.problem7.domain;

import java.util.HashSet;
import java.util.Set;

public class Friends {
    private final Set<String> friends;
    
    public Friends() {
        this(new HashSet<>());
    }
    
    public Friends(final Set<String> friends) {
        this.friends = friends;
    }
    
    public void add(final String friend) {
        friends.add(friend);
    }
    
    public int numberOfFriendsYouKnowTogether(final Friends otherUserFriends) {
        return (int) otherUserFriends.friends.stream()
                .filter(friends::contains)
                .count();
    }
    
    public boolean contains(final String userName) {
        return friends.contains(userName);
    }
    
    public Set<String> friends() {
        return friends;
    }
    
    @Override
    public String toString() {
        return "Friends{" +
                "friends=" + friends +
                '}';
    }
}
