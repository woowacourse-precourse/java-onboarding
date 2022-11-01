package onboarding.problem7;

import java.util.List;

public class Member {
    private String name;
    private Integer point;

    public Member(String name, Integer point) {
        this.name = name;
        this.point = point;
    }

    public void upAcquaintancePoint(List<Member> userAndUserFriends) {
        if (userAndUserFriends.contains(this)) {
            this.point += 10;
        }
    }

    public void upVisitorPoint(List<Member> userAndUserFriends) {
        if (userAndUserFriends.contains(this)) {
            this.point += 1;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPoint() {
        return point;
    }
}
