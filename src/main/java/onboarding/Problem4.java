package onboarding;

public class Problem4 {
    public static String converse(char c) {
        if ('A' <= c && c <= 'Z') {
            String treeFrogDictionary = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
            return treeFrogDictionary.substring(c - 'A', c - 'A' + 1);
        }
        if ('a' <= c && c <= 'z') {
            String treeFrogDictionary = "zyxwvutsrqponmlkjihgfedcba";
            return treeFrogDictionary.substring(c - 'a', c - 'a' + 1);
        }
        return " ";
    }

    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            answer = answer + converse(c);
        }
        return answer;
    }
}
