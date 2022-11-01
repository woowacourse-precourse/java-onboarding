package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> friends = new ArrayList<>();
    private List<Member> visitors = new ArrayList<>();
    private List<Member> recommendedFriends = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    // this가 aMember의 친구인지 판별
    public boolean isFriendOf(Member aMember) {
        List<Member> aMemberFriends = aMember.getFriends();

        for (Member friend : aMemberFriends)
            if (friend.getName().equals(this.getName()))
                return true;

        return false;
    }

    // this가 aMember의 방문자인지 판별
    public boolean isVisitorOf(Member aMember) {
        List<Member> aMemberVisitors = aMember.getVisitors();

        for (Member friend : aMemberVisitors)
            if (friend.getName().equals(this.getName()))
                return true;

        return false;
    }

    /* Getter Setter */
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

    public void setRecommendedFriends(List<Member> recommendedFriends) {
        this.recommendedFriends = recommendedFriends;
    }
}
