package onboarding.problem6.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crew {
    private String email;
    private String nickname;

    public Crew(String email, String nickname) {
        validateNicknameLanguage(nickname);
        validateNicknameLength(nickname);
        validateEmailForm(email);
        validateEmailLength(email);

        this.email = email;
        this.nickname = nickname;
    }

    private void validateNicknameLanguage(String nickname) {
        String regularExpressionOfKorean = "^[가-힣]*$";
        if (!nickname.matches(regularExpressionOfKorean)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }
    }

    private void validateNicknameLength(String nickname) {
        int nicknameLength = nickname.length();
        if (nicknameLength >= 20 || nicknameLength < 1) {
            throw new IllegalArgumentException("닉네임의 길이는 1자 이상 20자 미만이어야 합니다.");
        }
    }

    private void validateEmailLength(String email) {
        int emailLength = email.length();
        if (emailLength >= 20 || emailLength < 11) {
            throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만이어야 합니다.");
        }
    }

    private void validateEmailForm(String email) {
        String regularExpressionOfEmailForm = "[\\w]+@email\\.com";
        if (!email.matches(regularExpressionOfEmailForm)) {
            throw new IllegalArgumentException("지원하지 않는 이메일 형식입니다.");
        }
    }

    public List<String> getTwoLetterListFromNickname() {
        List<String> twoLetterList = new ArrayList<>();
        int start = 0;
        int end = this.nickname.length() - 1;

        for (int i = start; i < end; i++) {
            String twoLetter = this.nickname.substring(i, i + 2);
            twoLetterList.add(twoLetter);
        }
        return twoLetterList;
    }

    public boolean isOverlappedWith(Crew crew) {
        List<String> twoLetterList = crew.getTwoLetterListFromNickname();
        boolean duplicateStatus = false;
        int index = 0;
        while (!duplicateStatus && index < twoLetterList.size()) {
            String twoLetter = twoLetterList.get(index);
            duplicateStatus = this.nickname.contains(twoLetter);
            index++;
        }
        return duplicateStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return nickname.equals(crew.nickname) && email.equals(crew.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, email);
    }

    public String getEmail() {
        return email;
    }
}
