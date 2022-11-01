package onboarding.problem7;

import java.util.ArrayList;

public class Person implements Comparable<Person> {

    String name;
    ArrayList<String> friendList = new ArrayList<>();
    int score = 0;
    boolean isFriend = false;

    public Person(String name) {
        this.name = name;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public void makeFriend() {
        this.isFriend = true;
    }

    public void addToFriendList(String name) {
        friendList.add(name);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    @Override
    public int compareTo(Person o) {
        if (o.score == this.score) return this.name.compareTo(o.name);
        return o.score - this.score;
    }
}
