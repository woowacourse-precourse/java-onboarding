package onboarding;

import java.util.List;

public class Problem6 {
    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;
    public static final int NUM_OF_LETTER = 2;
    public static final int MINIMUM_FORMS_RANGE = 1;
    public static final int MAXIMUM_FORMS_RANGE = 10000;
    public static final int MINIMUM_EMAIL_RANGE = 11;
    public static final int MAXIMUM_EMAIL_RANGE = 20;
    public static final int DOMAIN_INDEX = 1;
    public static final int KOREAN = 5;
    public static final int MINIMUM_NICKNAME_RANGE = 1;
    public static final int MAXIMUM_NICKNAME_RANGE = 20;
    public static final int VALID_EMAIL_LENGTH = 2;
    public static final String AT = "@";
    public static final String VALID_EMAIL_FORM = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
        validate(forms);
    }

    public static void validate(List<List<String>> forms) {
        validateRange(forms);

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            emails.add(getEmail(form));
            nicknames.add(getNickname(form));
        }

        validateEmail(emails);
        validateNickname(nicknames);
    }

    private static void validateRange(List<List<String>> forms) {
        if (forms.size() < MINIMUM_FORMS_RANGE || MAXIMUM_FORMS_RANGE < forms.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEmail(List<String> emails) {
        validateEmailRange(emails);
        validateEmailForm(emails);
    }

    private static void validateEmailRange(List<String> emails) {
        for (String email : emails) {
            if (email.length() < MINIMUM_EMAIL_RANGE || MAXIMUM_EMAIL_RANGE < email.length()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateEmailForm(List<String> emails) {
        for (String email : emails) {
            String[] splitEmail = email.split(AT);

            if (splitEmail.length != VALID_EMAIL_LENGTH) {
                throw new IllegalArgumentException();
            }

            String domain = splitEmail[DOMAIN_INDEX];
            if (!domain.equals(VALID_EMAIL_FORM)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateNickname(List<String> nicknames) {
        validateNicknameRange(nicknames);
        validateNicknameForm(nicknames);
    }

    private static void validateNicknameRange(List<String> nicknames) {
        for (String nickname : nicknames) {
            if (nickname.length() < MINIMUM_NICKNAME_RANGE || MAXIMUM_NICKNAME_RANGE < nickname.length()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateNicknameForm(List<String> nicknames) {
        for (String nickname : nicknames) {
            char[] toCharArray = nickname.toCharArray();
            for (char c : toCharArray) {
                if (Character.getType(c) != KOREAN) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static Set<String> splitNicknames(String nickname) {
        Set<String> substringNickname = new HashSet<>();
        int nicknameRange = nickname.length() - 1;

        for (int i = 0; i < nicknameRange; i++) {
            String substring = nickname.substring(i, i + NUM_OF_LETTER);
            substringNickname.add(substring);
        }

        return substringNickname;
    }

    private static String getEmail(List<String> form) {
        return form.get(EMAIL);
    }

    private static String getNickname(List<String> form) {
        return form.get(NICKNAME);
    }
}
