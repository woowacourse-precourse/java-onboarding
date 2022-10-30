package onboarding.problem6;

import java.util.Objects;
import java.util.regex.Pattern;

public class NickName {
    private static final Pattern korean = Pattern.compile("^[ㄱ-ㅎ|가-힣]$");
    private final String nickName;

    public NickName(String nickName) {
        checkKorean(nickName);
        this.nickName = nickName;
    }

    private static void checkKorean(String nickName) {
        if (!korean.matcher(nickName).matches()){
            throw new NickNameException("한글만 쓸 수 있습니다.");
        }
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NickName nickName1 = (NickName) o;
        return Objects.equals(nickName, nickName1.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName);
    }
}
