package onboarding;

import onboarding.problem2.ProblemTwoValidation;

import java.util.*;

public class Problem2 {

    private static ProblemTwoValidation validation = new ProblemTwoValidation();

    private static Stack<String> stack = new Stack<>();

    public static String solution(String cryptogram) {
        if (!checkStringLength(cryptogram)) {
            return "";
        }

        // 검증 코드 분리
        String validString = validation.getValidString();

        // 중복제거 코드 분리
        duplicatedStringRemoveProcess(validString);

        String result = String.join("", stack);
        stack.clear();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("zyelleyz"));
    }

    private static boolean checkStringLength(String cryptogram) {
        validation.settingCryptogram(cryptogram);
        if (validation.isLength()) {
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

            stack.add(splitData);
        }
    }

    private static boolean isDuplicatedString(String splitData) {
        return isNotEmpty() && isEquals(splitData);
    }

    // 너무 잘게 쪼게지는 않는 것이 좋을 거 같다
    private static void removeDuplicatedString() {
        stack.pop();
    }

    private static boolean isNotEmpty() {
        return !stack.isEmpty();
    }

    private static boolean isEquals(String splitData) {
        return stack.peek().equals(splitData);
    }
}
