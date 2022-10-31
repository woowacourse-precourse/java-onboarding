package onboarding;

public class Problem4 {

    public static boolean isAlpha(char alpha) {
        if(alpha >= 'A' && alpha <= 'Z' || alpha >= 'a' && alpha <= 'z'){
            return true;
        }
        return false;
    }

    public static String convertToTreefrogDictionary(String word) {
        char[] convertWord = word.toCharArray();

        for(int i = 0; i < convertWord.length; i++){
            if(!isAlpha(convertWord[i])) {
                continue;
            }

            if(Character.isUpperCase(convertWord[i])) {
                convertWord[i] = (char) ('Z' - convertWord[i] + 'A');
            } else {
                convertWord[i] = (char) ('z' - convertWord[i] + 'a');
            }
        }

        return String.valueOf(convertWord);
    }

    public static String solution(String word) {
        return convertToTreefrogDictionary(word);
    }
}