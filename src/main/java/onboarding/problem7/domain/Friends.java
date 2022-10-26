package onboarding.problem7.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Friends {
    private final Set<User> friends;
    
    public Friends() {
        this(new HashSet<>());
    }
    
    public Friends(final Set<User> friends) {
        this.friends = friends;
    }
    
    public void add(final User friend) {
        friends.add(friend);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Friends friends1 = (Friends) o;
        return Objects.equals(friends, friends1.friends);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(friends);
    }
    
    @Override
    public String toString() {
        return "Friends{" +
                "friends=" + friends +
                '}';
    }
}
