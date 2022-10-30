package onboarding.problem6;

public class CrewMember {

    private final String email;
    private final String nickname;

    public CrewMember(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
