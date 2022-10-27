package onboarding.domain.problem6;

public class NickName {
    private String nickname;
    public NickName(String nickname) {
        this.nickname = nickname;
    }

    public boolean hasOverlap(NickName other) {
        for (int i=0; i<nickname.length()-1;i++)
            if (other.nickname.contains(nickname.substring(i,i+2)))
                return true;
        return false;
    }
}
