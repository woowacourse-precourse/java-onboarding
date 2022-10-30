package onboarding.problem6;

public class Crew {
    private String nickname;
    private String email;

    public Crew(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public boolean isPossibleToMakeSnippets(){
        return nickname.length()>1;
    }

}
