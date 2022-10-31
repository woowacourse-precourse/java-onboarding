package onboarding.problem6;

import java.util.List;

public class Member implements Comparable<Member> {
    private final Email email;
    private final NickName nickName;

    public Member(Email email, NickName nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public Member(List<String> notCrew) {
        this.email = new Email(notCrew.get(0));
        this.nickName = new NickName(notCrew.get(1));
    }

    public boolean isDuplicate(Member crew) {
        return nickName.isDuplicate(crew.getNickName());
    }

    @Override
    public int compareTo(Member o) {
        if (isDuplicate(o)) {
            return 1;
        }
        return 0;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public NickName getNickName() {
        return nickName;
    }


    @Override
    public String toString() {
        return "Crew{" +
                "email=" + email +
                ", nickName=" + nickName +
                '}';
    }
}
