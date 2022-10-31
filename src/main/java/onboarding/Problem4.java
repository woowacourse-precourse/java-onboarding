package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return changeWord(word);
    }

    private static String changeWord(String word) {
        StringBuilder changedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char tempChar = word.charAt(i);
            if (isAlphabet(tempChar)) {
                tempChar = changeAlphabet(tempChar);
            }
            changedWord.append(tempChar);
        }

        return changedWord.toString();
    }

    private static boolean isAlphabet(char c) {
        return isUpperAlphabet(c) || isLowerAlphabet(c);
    }

    private static boolean isUpperAlphabet(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static boolean isLowerAlphabet(char c) {
        return 'a' <= c && c <= 'z';
    }

    private static char changeAlphabet(char c) {
        if (isUpperAlphabet(c)) {
            return changeUpperAlphabet(c);
        } else{
            return changeLowerAlphabet(c);
        }
    }

    private static char changeUpperAlphabet(char c) {
        int diff = 'Z' - c;
        return (char) ('A' + diff);
    }

    private static char changeLowerAlphabet(char c) {
        int diff = 'z' - c;
        return (char) ('a' + diff);
    }
}
