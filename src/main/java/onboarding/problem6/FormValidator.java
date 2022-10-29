package onboarding.problem6;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FormValidator {

    public static void validateSize(int size) {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 10_000;

        if (size < MIN_VALUE || MAX_VALUE < size) {
            throw new IllegalArgumentException("크루원은 1명 이상 10,000명 이하로 입력 해주세요.");
        }
    }

    public static void validateCrewInfo(List<Crew> crewList) {
        validateEmail(crewList.stream()
                .map(Crew::getEmail)
                .collect(Collectors.toList()));


        validateNickname(crewList.stream()
                .map(Crew::getNickname)
                .collect(Collectors.toList()));
    }

    private static void validateEmail(List<String> crewEmails) {
        final String domain = "@email.com";

        for (String crewEmail : crewEmails) {
            if (!crewEmail.contains(domain)) {
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

    private static void validateNickname(List<String> nicknames) {
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
