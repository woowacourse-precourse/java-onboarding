package onboarding;

public class Problem2 {
    public static String removeEachCharacter(String cryptogram, int startIndex, int endIndex) {
        return cryptogram.replaceFirst(cryptogram.substring(startIndex, endIndex + 1), "");
    }

    public static boolean isDuplicated(String cryptogram, int currentIndex, int compareIndex) {
        return cryptogram.charAt(currentIndex) == cryptogram.charAt(compareIndex);
    }

    public static String removeDuplicatedCharacters(String cryptogram, boolean hasDuplicatedCharacter) {
        int index = 0;
        int windowSize = 0;
        while (index < cryptogram.length() - 1) {
            if (isDuplicated(cryptogram, index, index + 1)) {
                windowSize++;
                hasDuplicatedCharacter = true;
            } else if (windowSize > 0) {
                cryptogram = removeEachCharacter(cryptogram, index - windowSize, index);
                windowSize = 0;
            }
            index++;
        }

        if (windowSize > 0) {
            cryptogram = removeEachCharacter(cryptogram, index - windowSize, index);
        }

        if (cryptogram.length() == 0 || !hasDuplicatedCharacter) {
            return cryptogram;
        } else {
            return removeDuplicatedCharacters(cryptogram, false);
        }
    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicatedCharacters(cryptogram, false);

        return answer;
    }
}
