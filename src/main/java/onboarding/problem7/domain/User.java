package onboarding.problem7.domain;

import java.util.Set;

public class User implements Comparable<User> {
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
    
    public void addVisitScore() {
        this.score = score.increase();
    }
    
    public boolean isNotZeroScore() {
        return score.isNotZero();
    }
    
    public Set<String> getFriends() {
        return friends.getFriends();
    }
    
    public String getUserName() {
        return userName;
    }
    
    @Override
    public int compareTo(final User otherUser) {
        if (score.compareTo(otherUser.score) == 0) {
            return userName.compareTo(otherUser.userName);
        }
        
        return otherUser.score.compareTo(score);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", friends=" + friends +
                ", score=" + score +
                '}';
    }
}
