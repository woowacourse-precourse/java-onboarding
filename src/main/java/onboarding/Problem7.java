package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        User user1 = new User();
        user1.setUserName(user);

        List<String> answer = Collections.emptyList();
        return answer;
    }
}

class User implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getPoint() > o2.getPoint() ? 1 : ( o1.getPoint() < o2.getPoint() ? -1 : 0 );
    }

    private String userName;
    private int point;
    private List<User> friendList;

    public String getUserName() {
        return userName;
    }

    public int getPoint() {
        return point;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }


}
