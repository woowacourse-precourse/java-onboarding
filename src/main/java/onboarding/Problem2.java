package onboarding;

public class Problem2 {
    public static String removeEachCharacter(String cryptogram, int startIndex, int endIndex) {
        return cryptogram.replaceFirst(cryptogram.substring(startIndex, endIndex + 1), "");
    }

    public static boolean isDuplicated(String cryptogram, int currentIndex, int compareIndex) {
        return cryptogram.charAt(currentIndex) == cryptogram.charAt(compareIndex);
    }

    public static String removeDuplicatedCharacters(String cryptogram) {
        int index = 0;
        while (index < cryptogram.length() - 1) {
            if (isDuplicated(cryptogram, index, index + 1)) {
                cryptogram = removeEachCharacter(cryptogram, index, index + 1);
                index -= 2;
            }
            index++;
        }

        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = removeDuplicatedCharacters(cryptogram);

        return answer;
    }
}
