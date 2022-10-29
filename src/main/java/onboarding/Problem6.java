package onboarding;

import java.util.List;

public class Problem6 {
    static final int EMAIL_INDEX = 0;
    static final int NICK_NAME_INDEX = 1;
    static final int MIN_CREW_NUMBER = 1;
    static final int MAX_CREW_NUMBER = 10000;
    static final String EMAIL_FORM = "@email.com";
    static final int MIN_EMAIL_LENGTH = 11;
    static final int MAX_EMAIL_LENGTH = 19;
    static final int MIN_NICK_NAME_LENGTH = 1;
    static final int MAX_NICK_NAME_LENGTH = 19;
    static final List<String> ERROR = List.of("Error");
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (!isValidInput(forms)) {
            answer = ERROR;
            return answer;
        }
        return answer;
    }

    private static boolean isValidInput(List<List<String>> forms) {
        return isValidCrewNumber(forms) && isValidEmailForm(forms)
                && isValidEmailLength(forms) && isValidNickNameLength(forms);
    }

    private static boolean isValidNickNameLength(List<List<String>> forms) {
        String crewNickName;
        int nickNameLength;

        for (List<String> crew : forms) {
            crewNickName = crew.get(NICK_NAME_INDEX);
            nickNameLength = crewNickName.length();
            if (nickNameLength < MIN_NICK_NAME_LENGTH || nickNameLength > MAX_NICK_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidEmailLength(List<List<String>> forms) {
        String crewEmail;
        int emailLength;

        for (List<String> crew : forms) {
            crewEmail = crew.get(EMAIL_INDEX);
            emailLength = crewEmail.length();
            if (emailLength < MIN_EMAIL_LENGTH || emailLength > MAX_EMAIL_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidEmailForm(List<List<String>> forms) {
        String crewEmail;

        for (List<String> crew : forms) {
            crewEmail = crew.get(EMAIL_INDEX);
            if (!crewEmail.endsWith(EMAIL_FORM)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCrewNumber(List<List<String>> forms) {
        int crewNumber = forms.size();

        return crewNumber >= MIN_CREW_NUMBER && crewNumber <= MAX_CREW_NUMBER;
    }
}
