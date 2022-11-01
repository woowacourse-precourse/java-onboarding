package onboarding.problem7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class User extends Domain{

    private String userName;

    private ArrayList<User> friends=new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void validUserName(){
        String pattern="^[a-z]*$";
        if(!Pattern.matches(pattern,userName)) throw new IllegalArgumentException("잘못된 아이디 입니다.");
    }

    public Iterator<User> getFriends() {
        return friends.iterator();
    }

    public void addFriend(User findFriend) {
        friends.add(findFriend);
        findFriend.friends.add(this);
    }
}
