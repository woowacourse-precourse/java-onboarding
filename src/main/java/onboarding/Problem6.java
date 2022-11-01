package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int FORM_MIN_LENGTH = 1;
    private static final int FORM_MAX_LENGTH = 10000;
    private static final int FORM_ELEMENT_SIZE = 2;
    private static final int EMAIL_MIN_LENGTH = 11;
    private static final int EMAIL_MAX_LENGTH = 20;
    private static final String DOMAIN = "email.com";
    private static final int NICKNAME_MIN_LENGTH = 1;
    private static final int NICKNAME_MAX_LENGTH = 20;

    public static List<String> solution(List<List<String>> forms) {
        if(!checkFormValidation(forms)) {
            throw new IllegalArgumentException("[error] 잘못된 forms를 입력하셨습니다.");
        }
        List<String> answer = getEmailListOfOverlapedNickname(forms);
        return sortEmailList(answer);
    }

    // forms에서 email 리스트를 추출하는 기능
    public static List<String> extractEmailList(List<List<String>> forms) {
        return forms.stream()
            .map(form -> form.get(0))
            .collect(Collectors.toList());
    }

    // forms에서 nickname 리스트를 추출하는 기능
    public static List<String> extractNicknameList(List<List<String>> forms) {
        return forms.stream()
            .map(form -> form.get(1))
            .collect(Collectors.toList());
    }

    // form의 길이가 1이상 10,000이하인지 검증하는 기능
    public static boolean checkFormsLength(List<List<String>> forms) {
        return FORM_MIN_LENGTH <= forms.size() && forms.size() <= FORM_MAX_LENGTH;
    }

    // form의 각 원소의 길이가 2인지 검증하는 기능
    public static boolean checkFormsElementLength(List<List<String>> forms) {
        for (List<String> formElement : forms) {
            if (!(formElement.size() == FORM_ELEMENT_SIZE)) {
                return false;
            }
        }
        return true;
    }

    // 이메일의 길이가 11자 이상 20자 미만인지 검증하는 기능
    public static boolean checkEmailLength(List<String> emails) {
        for (String email : emails) {
            if (!(EMAIL_MIN_LENGTH <= email.length() && email.length() < EMAIL_MAX_LENGTH)) {
                return false;
            }
        }
        return true;
    }

    // 이메일 도메인이 email.com 인지 검증하는 기능
    public static boolean checkEmailDomain(List<String> emails) {
        for (String email : emails) {
            if (!email.contains("@")) {
                return false;
            }
            String domain = email.split("@")[1];
            if (!domain.equals(DOMAIN)) {
                return false;
            }
        }
        return true;
    }

    // 닉네임이 한글로만 구성되어 있는지 검증하는 기능
    public static boolean checkNicknameConsistOfHangul(List<String> nicknames) {
        for (String nickname : nicknames) {
            if (!nickname.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$")) {
                return false;
            }
        }
        return true;
    }

    // nickname의 길이가 1이상 20미만인지 검증하는 기능
    public static boolean checkNicknameLength(List<String> nicknames) {
        for (String nickname : nicknames) {
            if (!(NICKNAME_MIN_LENGTH <= nickname.length()
                && nickname.length() < NICKNAME_MAX_LENGTH)) {
                return false;
            }
        }
        return true;
    }

    // 제한사항 한번에 실행하는 기능
    public static boolean checkFormValidation(List<List<String>> forms) {
        List<String> emails = extractEmailList(forms);
        List<String> nicknames = extractNicknameList(forms);
        if (!(checkFormsLength(forms) && checkFormsElementLength(forms)
            && checkEmailLength(emails) && checkEmailDomain(emails)
            && checkNicknameConsistOfHangul(nicknames) && checkNicknameLength(nicknames))) {
            return false;
        }
        return true;
    }


    // 닉네임 중 두 글자 이상 중복되는지 판별하는 기능
    public static boolean checkNicknameOverlapMoreThanTwoWord(String nickname,
        String nextNickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            if (nextNickname.contains(nickname.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    // 연속된 두 글자 이상 중복된 닉네임의 이메일 리스트를 반환하는 기능
    public static List<String> getEmailListOfOverlapedNickname(List<List<String>> forms) {
        List<String> emails = extractEmailList(forms);
        List<String> nicknames = extractNicknameList(forms);
        Set<String> result = new HashSet<>();
        for (int i = 0; i < nicknames.size() - 1; i++) {
            if (nicknames.get(i).length() == 1) {
                continue;
            }
            for (int j = i + 1; j < nicknames.size(); j++) {
                if (checkNicknameOverlapMoreThanTwoWord(nicknames.get(i), nicknames.get(j))) {
                    result.add(emails.get(i));
                    result.add(emails.get(j));
                }
            }
        }
        return List.copyOf(result);
    }

    // 이메일 리스트 오름차순으로 정렬하는 기능
    public static List<String> sortEmailList(List<String> email) {
        return email.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
