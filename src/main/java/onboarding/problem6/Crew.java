package onboarding.problem6;

public class Crew {
    private final String email;
    private String nickname;

    public Crew(String email){
        this.email = email;
    }

    public Crew(String email, String nickname){
        this.email = email;
        setNickname(nickname);
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
