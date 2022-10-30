package onboarding.problem6;

import java.util.*;
import java.util.regex.Pattern;

public class NickName {
    private static final Pattern korean = Pattern.compile("^[ㄱ-ㅎ|가-힣]{1,20}$");
    private final String nickName;
    private final List<String> separateNicks = new ArrayList<>();

    public NickName(String nickName) {
        checkKorean(nickName);
        this.nickName = nickName;
        separateTwoParts();
    }



    private static void checkKorean(String nickName) {
        if (!korean.matcher(nickName).matches()) {
            throw new NickNameException("한글만 쓸 수 있습니다.");
        }
    }
    public boolean isDuplicate(NickName compareNick) {
        List<String> toNick = compareNick.getSeparateNicks();

        return separateNicks.stream()
                .anyMatch(toNick::contains);
    }

    private void separateTwoParts() {
        int i = 0;
        int duplicateLimit = 2;
        while (i < nickName.length()) {
            separateNicks.add(nickName.substring(i, i + duplicateLimit));
            i++;
            if (i + duplicateLimit > nickName.length()) {
                break;
            }
        }
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
    public String getNickName() {
        return nickName;
    }
    public List<String> getSeparateNicks() {
        return Collections.unmodifiableList(separateNicks);
    }
}
