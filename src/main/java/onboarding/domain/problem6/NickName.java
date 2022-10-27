package onboarding.domain.problem6;

public class NickName {
    public static boolean hasOverlap(String nickname, String otherName) {
        for (int i=0; i<nickname.length()-1;i++)
            if (otherName.contains(nickname.substring(i,i+2)))
                return true;
        return false;
    }
}
