package onboarding;

import java.util.stream.IntStream;

public class Problem2 {

    public static String solution(String cryptogram) {
        validate(cryptogram);
        return decode(cryptogram);
    }

    private static void validate(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("길이가 1 이상 1000 이하인 문자열이어야 합니다.");
        }
        for (char character : cryptogram.toCharArray()) {
            if (!(Character.isLowerCase(character) && Character.isAlphabetic(character))) {
                throw new IllegalArgumentException("알파벳 소문자로만 이루어져 있어야 합니다.");
            }
        }
    }

    private static String decode(String cryptogram) {
        while (isExistDuplicatedMessage(cryptogram)) {
            cryptogram = removeDuplicatedMessages(cryptogram);
        }
        return cryptogram;
    }

    private static boolean isExistDuplicatedMessage(String cryptogram) {
        return IntStream.range(1, cryptogram.length()).anyMatch(index -> isDuplicate(cryptogram, index));
    }

    private static String removeDuplicatedMessages(String cryptogram) {
        StringBuilder message = new StringBuilder(cryptogram);
        for (int index = 1; index < message.length(); index++) {
            index = removeDuplicatedMessage(message, index);
        }
        return message.toString();
    }

    private static int removeDuplicatedMessage(StringBuilder message, int index) {
        if (isDuplicate(message.toString(), index)) {
            message.replace(index - 1, index + 1, "");
            index++;
        }
        return index;
    }

    private static boolean isDuplicate(String message, int index) {
        return message.charAt(index - 1) == message.charAt(index);
    }
}
