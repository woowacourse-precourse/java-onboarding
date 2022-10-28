package onboarding;

import onboarding.problem2.ProblemTwoValidation;

import java.util.*;

public class Problem2 {

    private static final ProblemTwoValidation VALIDATION = new ProblemTwoValidation();
    private static final Stack<String> STACK = new Stack<>();

    public static String solution(String cryptogram) {
        if (!checkStringLength(cryptogram)) {
            return VALIDATION.getValidString();
        }

        String validString = VALIDATION.getValidString();
        duplicatedStringRemoveProcess(validString);
        return String.join("", STACK);
    }

    private static boolean checkStringLength(String cryptogram) {
        VALIDATION.settingCryptogram(cryptogram);
        if (VALIDATION.isLength()) {
            return true;
        }
        return false;
    }

    private static void duplicatedStringRemoveProcess(String validString) {
        String[] validStringToStringSplit = validString.split("");

        for (String splitData : validStringToStringSplit) {

            if (isDuplicatedString(splitData)) {
                removeDuplicatedString();
                continue;
            }

            STACK.add(splitData);
        }
    }

    private static boolean isDuplicatedString(String splitData) {
        return isNotEmpty() && isEquals(splitData);
    }

    private static void removeDuplicatedString() {
        STACK.pop();
    }

    private static boolean isNotEmpty() {
        return !STACK.isEmpty();
    }

    private static boolean isEquals(String splitData) {
        return STACK.peek().equals(splitData);
    }
}
