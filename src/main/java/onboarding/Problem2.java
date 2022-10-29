package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Problem2 {
    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        System.out.println("cryptogram = " + "\"" + cryptogram + "\"");
        System.out.println("result = " + "\"" + solution(cryptogram) + "\"");
        System.out.println();
        cryptogram = "zyelleyz";
        System.out.println("cryptogram = " + "\"" + cryptogram + "\"");
        System.out.println("result = " + "\"" + solution(cryptogram) + "\"");
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        CryptogramValidator.checkException(cryptogram);
        answer = decrypt(cryptogram);
        return answer;
    }

    private static String decrypt(String cryptogram) {
        List<Character> charList = new LinkedList<>();

        splitString(cryptogram, charList);
        removeDuplicateChar(charList);
        return combineChar(charList);
    }

    private static String combineChar(List<Character> charList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : charList) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    private static List<Character> removeDuplicateChar(List<Character> charList) {
        for (int i = 1; i < charList.size(); i++) {
            if (isDuplicate(charList, i)) {
                charList.remove(i - 1);
                charList.remove(i - 1);
                i = 0;
            }
        }
        return charList;
    }

    private static boolean isDuplicate(List<Character> charList, int i) {
        return Objects.equals(charList.get(i - 1), charList.get(i));
    }

    private static List<Character> splitString(String cryptogram, List<Character> charList) {
        char[] chars = cryptogram.toCharArray();
        for (char aChar : chars) {
            charList.add(aChar);
        }
        return charList;
    }

    private static class CryptogramValidator {
        private static final int MIN_CRYPTOGRAM_LENGTH = 1;
        private static final int MAX_CRYPTOGRAM_LENGTH = 1000;

        public static void checkException(String cryptogram) {
            if (isNull(cryptogram) || checkLengthOfCryptogram(cryptogram)) {
                throw new IllegalArgumentException(
                    "The cryptogram's length should be between 1 and 1000.");
            }
            if (isUpperCase(cryptogram)) {
                throw new IllegalArgumentException("The cryptogram should be lowercase.");
            }
        }

        private static boolean isNull(String cryptogram) {
            return Objects.isNull(cryptogram);
        }

        private static boolean checkLengthOfCryptogram(String cryptogram) {
            return cryptogram.length() < MIN_CRYPTOGRAM_LENGTH ||
                cryptogram.length() > MAX_CRYPTOGRAM_LENGTH;
        }

        private static boolean isUpperCase(String cryptogram) {
            char[] chars = cryptogram.toCharArray();
            for (char aChar : chars) {
                if (Character.isUpperCase(aChar)) {
                    return true;
                }
            }
            return false;
        }
    }
}
