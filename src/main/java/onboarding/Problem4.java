package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getWord(word);
    }

    private static String getWord(String word) {
        char[] wordList = word.toCharArray();

        int upperSum = 'A' + 'Z';
        int lowerSum = 'a' + 'z';

        for (int i = 0; i < wordList.length; i++) {
            if (Character.isUpperCase(wordList[i])) wordList[i] = (char) (upperSum - wordList[i]);
            if (Character.isLowerCase(wordList[i])) wordList[i] = (char) (lowerSum - wordList[i]);
        }

        return String.valueOf(wordList);
    }
}
