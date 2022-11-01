package onboarding;

import java.util.ArrayList;
import java.util.List;

public class SNSUser implements Comparable<SNSUser> {
    private int score;
    private List<String> friendList;
    private String userName;

    public SNSUser(String userName) {
        this.score = 0;
        this.userName = userName;
        this.friendList = new ArrayList<>();
    }

    public void addFriend(String friend) {
        this.friendList.add(friend);
    }

    @Override
    public int compareTo(SNSUser o) {
        return o.score - this.score;
    }

    public void compareFriend(SNSUser user) {
        List<String> opponentFriendList = user.friendList;
        // todo
        for (String myFriend :
                friendList) {
            if (opponentFriendList.contains(myFriend))
                this.score += 10;
        }
    }

    public void addVisitor() {
        this.score++;
    }

    public List<String> getFriendList() {
        return this.friendList;
    }

    public int getScore() {
        return this.score;
    }

    public String getUserName() {
        return this.userName;
    }
}
