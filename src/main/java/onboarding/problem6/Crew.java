package onboarding.problem6;

import java.util.List;

public class Crew implements Comparable<Crew> {
    private final Email email;
    private final NickName nickName;

    public Crew(Email email, NickName nickName) {
        this.email = email;
        this.nickName = nickName;
    }

    public Crew(List<String> notCrew) {
        this.email = new Email(notCrew.get(0));
        this.nickName = new NickName(notCrew.get(1));
    }

    public boolean isDuplicate(Crew crew) {
        return nickName.isDuplicate(crew.getNickName());
    }

    @Override
    public int compareTo(Crew o) {
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
