package onboarding.problem7.vo;

import java.util.Objects;

public class Member implements Comparable<Member> {
    private final String name;
    private final boolean isAlreadyFriend;
    private Integer score;

    public Member(String name, boolean isAlreadyFriend, Integer score) {
        this.name = name;
        this.isAlreadyFriend = isAlreadyFriend;
        this.score = score;
    }

    public static Member of(String name) {
        return new Member(name, false, 0);
    }

    public static Member ofAlreadyFriend(String name) {
        return new Member(name, true, 0);
    }

    public void addScore(Integer score) {
        if (!isAlreadyFriend) {
            this.score += score;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public boolean isAlreadyFriend() {
        return isAlreadyFriend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Member))
            return false;
        Member member = (Member)o;
        return name.equals(member.name);
    }

    @Override
    public int compareTo(Member o) {
        return name.compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", isAlreadyFriend=" + isAlreadyFriend +
                ", score=" + score +
                '}';
    }
}
