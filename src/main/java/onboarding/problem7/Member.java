package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> friends = new ArrayList<>();;
    private List<Member> visitors = new ArrayList<>();;
    private List<Member> recommendedFriends = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getFriends() {
        return friends;
    }

    public List<Member> getVisitors() {
        return visitors;
    }

    public List<Member> getRecommendedFriends() {
        return recommendedFriends;
    }

}
