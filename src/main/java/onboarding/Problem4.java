package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (Character.isLetter(wordArray[i])) {
                if (Character.isUpperCase(wordArray[i])) {
                    wordArray[i] = (char)(155 - (int)wordArray[i]);
                } else {
                    wordArray[i] = (char)(219 - (int)wordArray[i]);
                }
            }
        }
        return String.valueOf(wordArray);
    }
}
