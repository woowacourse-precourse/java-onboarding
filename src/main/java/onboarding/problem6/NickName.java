package onboarding.problem6;

import java.util.Objects;

public class NickName {
    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
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
