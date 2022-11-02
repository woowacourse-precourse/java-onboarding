package onboarding;

public class Problem4 {
    private static final int ASCII_UPPER_A = 65;
    private static final int ASCII_LOWER_A = 97;
    private static final int ASCII_UPPER_Z = 90;
    private static final int ASCII_LOWER_Z = 122;
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            sb.append(convertWord(c));
        }
        return sb.toString();
    }
    private static char convertWord(char word) {
        if(isLowerChar(word)){
            return convertLowerChar(word);
        }
        if(isUpperChar(word)){
            return convertUpperChar(word);
        }

        return word;
    }
    private static boolean isUpperChar(char word) {
        return word > ASCII_UPPER_A && word < ASCII_UPPER_Z;
    }

    private static boolean isLowerChar(char word) {
        return word > ASCII_LOWER_A && word < ASCII_LOWER_Z;
    }

    private static char convertLowerChar(char word) {
        return (char) (ASCII_LOWER_Z - (word - ASCII_LOWER_A));
    }

    private static char convertUpperChar(char word) {
        return (char) (ASCII_UPPER_Z - (word - ASCII_UPPER_A));
    }
}