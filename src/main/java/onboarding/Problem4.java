package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        return getDictWord(word);
    }

    private static String getDictWord(String word){

        char[] chars = word.toCharArray();
        char[] result = new char[word.length()];

        for (int i=0; i<word.length(); i++){
            result[i] = toDictChar(chars[i]);
        }
        return new String(result);
    }

    public static char toDictChar(char ch){
        final char[] UPPER = new char[]{'A', 'Z'};
        final char[] LOWER = new char[]{'a', 'z'};

        int dictWord = ch;
        if (Character.isUpperCase(ch)) {
            dictWord = getDictAsc(UPPER, ch);
        } else if (Character.isLowerCase(ch)) {
            dictWord = getDictAsc(LOWER, ch);
        }

        return (char) dictWord;
    }

    private static int getDictAsc(char[] ascRange, char originalWord){
        char start = ascRange[0];
        char end = ascRange[1];

        int ascDistance = originalWord - start;
        return end - ascDistance;
    }




}
