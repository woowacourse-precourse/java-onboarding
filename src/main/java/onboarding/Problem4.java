package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();

        for(int i=0; i<chars.length; i++) {
            chars[i] = momToChild(chars[i]);
        }

        return new String(chars);
    }

    private static char momToChild(char word) {
        if(Character.isWhitespace(word)) return word;

        char childWord;
        if(Character.isUpperCase(word)) childWord = (char) ('Z' - (word - 'A'));
        else childWord = (char) ('z' - (word - 'a'));
        return childWord;
    }
}
