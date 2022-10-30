package onboarding.problem7;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Account {

    private final String id;
    private final Set<Account> friendsRelation;
    private int score;

    public Account(String id) {
        this.id = id;
        this.friendsRelation = new HashSet<>();
        this.score = 0;
    }

    public void addFriend(Account friend) {
        friendsRelation.add(friend);
    }

    public boolean isAccountId(String id) {
        return this.id.equals(id);
    }

    public boolean isFriend(String id) {
        return friendsRelation.stream().anyMatch(account -> account.isAccountId(id));
    }

    public void addScore(int score) {
        this.score += score;
    }

    public boolean scoreOverThanZero() {
        return score > 0;
    }

    public boolean isEqualsScore(Account account) {
        return this.score == account.getScore();
    }

    public String getId() {
        return this.id;
    }

    public int getScore() {
        return this.score;
    }

    public Stream<Account> getFriendRelationStream() {
        return friendsRelation.stream();
    }
}
