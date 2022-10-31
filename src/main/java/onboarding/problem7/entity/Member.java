package onboarding.problem7.entity;

import java.util.Objects;

/**
 * 친구추천 알고리즘에 사용되는 사용자 정보를 담은 ENTITY 객체입니다.
 * @author BackFoxx
 */
public class Member implements Comparable<Member> {
    private final String name;
    private final boolean isAlreadyFriend;
    private Integer score;

    public Member(String name, boolean isAlreadyFriend, Integer score) {
        this.name = name;
        this.isAlreadyFriend = isAlreadyFriend;
        this.score = score;
    }

    /**
     * 주어진 이름으로 기본 Member 객체를 만드는 메소드입니다.
     * @param name 사용자의 이름입니다.
     */
    public static Member of(String name) {
        return new Member(name, false, 0);
    }

    /**
     * 친구추천의 주체가 되는 사용자와 이미 친구관계를 맺고 있는 Member 객체를 만드는 메소드입니다.
     * @param name 사용자의 이름입니다.
     */
    public static Member ofAlreadyFriend(String name) {
        return new Member(name, true, 0);
    }

    /**
     * 주어진 값 만큼 Member 의 점수를 올리는 메소드입니다.
     * @param score 추가할 점수 값입니다.
     */
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
