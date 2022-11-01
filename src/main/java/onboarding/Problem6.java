package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        answer = getDuplicatedNickNameCrew(forms);
        return answer;
    }

    private static List<String> getDuplicatedNickNameCrew(List<List<String>> forms) {
        Map<String, Map<String, List<String>>> nickNameMap = new HashMap<>();
        Set<String> duplicatedNickNameEmails = new HashSet<>();
        List<String> duplicatedNickNameEmailsToList = new ArrayList<>();
        String crewEmail;
        List<String> crewEmails;
        String crewNickName;
        String nickNameOneLetter;
        String nickNameNextOneLetter;

        for (List<String> crew : forms) {
            crewEmail = crew.get(EMAIL_INDEX);
            crewNickName = crew.get(NICK_NAME_INDEX);
            for (int i = 0; i < crewNickName.length(); i++) {
                nickNameOneLetter = crewNickName.substring(i, i + 1);
                if (!(nickNameMap.containsKey(nickNameOneLetter))) {
                    Map<String, List<String>> crewInfo = new HashMap<>();
                    if (i < crewNickName.length() - 1) {
                        nickNameNextOneLetter = crewNickName.substring(i + 1, i + 2);
                        crewEmails = new LinkedList<>();
                        crewEmails.add(crewEmail);
                        crewInfo.put(nickNameNextOneLetter, crewEmails);
                    }
                    nickNameMap.put(nickNameOneLetter, crewInfo);
                } else if (nickNameMap.containsKey(nickNameOneLetter)) {
                    if (i < crewNickName.length() - 1) {
                        nickNameNextOneLetter = crewNickName.substring(i + 1, i + 2);
                        if (!(nickNameMap.get(nickNameOneLetter).containsKey(nickNameNextOneLetter))) {
                            crewEmails = new LinkedList<>();
                            crewEmails.add(crewEmail);
                            nickNameMap.get(nickNameOneLetter).put(nickNameNextOneLetter, crewEmails);
                        } else if (nickNameMap.get(nickNameOneLetter).containsKey(nickNameNextOneLetter)) {
                            crewEmails = nickNameMap.get(nickNameOneLetter).get(nickNameNextOneLetter);
                            crewEmails.add(crewEmail);
                            for (String crewEmailToSet : crewEmails) {
                                duplicatedNickNameEmails.add(crewEmailToSet);
                            }
                            nickNameMap.get(nickNameOneLetter).put(nickNameNextOneLetter, crewEmails);
                        }
                    }
                }
            }
        }
        duplicatedNickNameEmailsToList = new ArrayList<>(duplicatedNickNameEmails);
        Collections.sort(duplicatedNickNameEmailsToList);
        return duplicatedNickNameEmailsToList;
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
