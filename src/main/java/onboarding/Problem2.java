package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//public class Problem2 {
//
//    private static final int TWO = 2;
//    private static final int INPUT_LEN_MIN = 1;
//    private static final int INPUT_LEN_MAX = 1000;
//    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";
//
//    public static String solution(String cryptogram) {
//        validateCryptogram(cryptogram);
//        return removeDuplicatedStr(cryptogram);
//    }
//
//    private static String removeDuplicatedStr(String cryptogram) {
//        Stack<String> stack = new Stack<>();
//
//        int i=-1;
//        while (++i < cryptogram.length()) {
//            char word = cryptogram.charAt(i);
//            while (word != cryptogram.charAt(i+1)) {
//                i++;
//            }
//            removeDuplicatedStrInStack(String.valueOf(cryptogram.charAt(i)), stack);
//        }
//
//        for (char word : cryptogram.toCharArray()) {
//            removeDuplicatedStrInStack(String.valueOf(word), stack);
//        }
//        return stack.stream()
//            .collect(Collectors.joining());
//    }
//
//    private static void removeDuplicatedStrInStack(String word, Stack<String> stack) {
//        int beforeRemoveStackSize = stack.size();
//
//        while (!stack.isEmpty() && word.equals(stack.peek())) {
//            stack.pop();
//        }
//        if (beforeRemoveStackSize == stack.size()) {
//            stack.add(word);
//        }
//    }
//
//    private static void validateCryptogram(String cryptogram) {
//        if (!isValidCryptogramForm(cryptogram) || !isValidCryptogramLen(cryptogram)) {
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private static boolean isValidCryptogramLen(String cryptogram) {
//        return cryptogram.length() >= INPUT_LEN_MIN && cryptogram.length() <= INPUT_LEN_MAX;
//    }
//
//    private static boolean isValidCryptogramForm(String cryptogram) {
//        return Pattern.matches(LOWER_ALPHABET_REGEX, cryptogram);
//    }
//}

public class Problem2 {

    public static String solution(String cryptogram) {
        return null;
    }
}