package onboarding;

import onboarding.problem2.CryptogramConverter;
import onboarding.problem2.ProblemTwoValidation;

import java.util.*;

public class Problem2 {

    private static Stack<String> stack = new Stack<>();

    public static String solution(String cryptogram) {
        CryptogramConverter convertor;
        try {
            convertor = new CryptogramConverter(new ProblemTwoValidation(cryptogram));
            convertor.duplicatedWord(cryptogram);

            return convertor.getConverterWord();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("zyelleyz"));
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
