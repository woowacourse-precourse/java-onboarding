package onboarding;

import java.util.*;

public class Problem6 {

    private static final int MIN_CREW_COUNT = 1;
    private static final int MAX_CREW_COUNT = 10000;
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 19;
    private static final String VALID_EMAIL_DOMAIN = "@email.com";
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 19;

    private static final int FORM_EMAIL_INDEX = 0;
    private static final int FORM_NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {

        return getRestrictedNicknames(forms);
    }

    private static List<String> getRestrictedNicknames(List<List<String>> forms) {
        Set<String> restrictedNicknames = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (validateNicknameDuplication(getFormName(forms, i), getFormName(forms, j))) {
                    restrictedNicknames.add(getFormEmail(forms, i));
                    restrictedNicknames.add(getFormEmail(forms, j));
                }
            }
        }

        return new ArrayList<>(restrictedNicknames);
    }

    static boolean validateNicknameDuplication(String input, String target) {
        for (int left = 0; left < input.length() - 2; left++) {
            int right = left + 2;
            if (right > input.length()) return false;

            String inputSub = input.substring(left, right);

            if (target.contains(inputSub)) return true;
        }

        return false;
    }

    static String getFormEmail(List<List<String>> forms, int index) {
        return forms.get(index).get(FORM_EMAIL_INDEX);
    }

    static String getFormName(List<List<String>> forms, int index) {
        return forms.get(index).get(FORM_NICKNAME_INDEX);
    }

    static void checkForExceptions(List<List<String>> forms) {
        if (!validateCrewCount(forms)) {
            throw new IllegalArgumentException("크루원은 1명 이상 10,000명 이하이어야 합니다.");
        }
        if (!validateEmailLength(forms)) {
            throw new IllegalArgumentException("이메일의 길이는 11자 이상 19자 이하이어야 합니다.");
        }
        if (!validateEmailDomain(forms)) {
            throw new IllegalArgumentException("신청 가능하신 이메일의 도메인은 @email.com 입니다.");
        }
        if (!validateNicknameLength(forms)) {
            throw new IllegalArgumentException("닉네임의 길이는 1자 이상 19자 이하이어야 합니다.");
        }
    }

    static boolean validateCrewCount(List<List<String>> forms) {
        return forms.size() >= MIN_CREW_COUNT && forms.size() <= MAX_CREW_COUNT;
    }

    static boolean validateEmailLength(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_EMAIL_INDEX).length() >= MIN_EMAIL_LENGTH && form.get(FORM_EMAIL_INDEX).length() <= MAX_EMAIL_LENGTH);
    }

    static boolean validateEmailDomain(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_EMAIL_INDEX).contains(VALID_EMAIL_DOMAIN));
    }

    static boolean validateNicknameLength(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_NICKNAME_INDEX).length() >= MIN_NICKNAME_LENGTH && form.get(FORM_NICKNAME_INDEX).length() <= MAX_NICKNAME_LENGTH);
    }
}
