package onboarding.problem6.crew;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CrewFactory {

    public List<Crew> getCrewList(List<List<String>> forms) {
        validateForms(forms);
        List<Crew> crewList = new ArrayList<>();

        for (List<String> form : forms) {  // mail, nickname
            String email = form.get(0);
            String nickname = form.get(1);

            crewList.add(new Crew(email, nickname));
        }

        return crewList;
    }

    private void validateForms(List<List<String>> forms) {
        validateEmail(forms.stream()
                .map(form -> form.get(0))
                .collect(Collectors.toList()));

        validateNickname(forms.stream()
                .map(form -> form.get(1))
                .collect(Collectors.toList()));
    }

    private void validateEmail(List<String> crewEmails) {
        final String domain = "@email.com";

        for (String crewEmail : crewEmails) {
            if (!crewEmail.endsWith(domain)) {
                throw new IllegalArgumentException("올바른 이메일 도메인이 아닙니다. @email.com 만 가능합니다.");
            }

            int emailLength = crewEmail.length();
            final int MIN_LENGTH = 11;
            final int MAX_LENGTH = 20;

            if (emailLength < MIN_LENGTH || MAX_LENGTH < emailLength) {
                throw new IllegalArgumentException("이메일 주소의 길이는 11자 이상, 20자 미만이어야 합니다.");
            }
        }
    }

    private void validateNickname(List<String> nicknames) {
        String regex = String.valueOf(Pattern.compile("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$"));

        for (String nickname : nicknames) {
            int nicknameLength = nickname.length();
            final int MIN_LENGTH = 1;
            final int MAX_LENGTH = 20;

            if (nicknameLength < MIN_LENGTH || MAX_LENGTH <= nicknameLength) {
                throw new IllegalArgumentException("닉네임은 1자 이상, 20자 미만이어야 합니다.");
            }

            if (!nickname.matches(regex)) {
                throw new IllegalArgumentException("닉네임은 한글만 입력해 주세요.");
            }
        }
    }
}
