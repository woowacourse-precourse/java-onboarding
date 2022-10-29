package onboarding.problem7.domain;

public class User implements Comparable<User> {
    private final UserBasicInformation userBasicInformation;
    private final Friends friends;
    
    public User(String userName) {
        this(new Friends(), new UserBasicInformation(userName));
    }
    
    public User(final Friends friends, final UserBasicInformation userBasicInformation) {
        this.userBasicInformation = userBasicInformation;
        this.friends = friends;
    }
    
    public void addFriend(final String friend) {
        friends.add(friend);
    }
    
    public int numberOfFriendsYouKnowTogether(final User user) {
        return friends.numberOfFriendsYouKnowTogether(user.friends);
    }
    
    public void addScoreOfNumberOfFriendsYouKnowTogether(final int numberOfFriendsYouKnowTogether) {
        userBasicInformation.addScoreOfNumberOfFriendsYouKnowTogether(numberOfFriendsYouKnowTogether);
    }
    
    public void addScoreOfVisit() {
        userBasicInformation.scoreIncrease();
    }
    
    public boolean isNotZeroScore() {
        return userBasicInformation.isScoreNotZero();
    }
    
    public boolean friendsContains(final String userName) {
        return friends.contains(userName);
    }
    
    public String getUserName() {
        return userBasicInformation.getUserName();
    }
    
    @Override
    public int compareTo(final User otherUser) {
        return userBasicInformation.compareTo(otherUser.userBasicInformation);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userBasicInformation=" + userBasicInformation +
                ", friends=" + friends +
                '}';
    }
}
