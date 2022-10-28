package onboarding;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> frogDictionary = new HashMap<>();
        String answer = "";

        for (int i = 0; i < 26; i++) {
            Character alpha = (char) ('A' + i);
            frogDictionary.put(alpha, (char)('Z' - i));
        }

        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if ( !isAlpha(curChar) ) {
                answer += curChar;
                continue;
            }
        }

        return answer;
    }

    static boolean isAlpha(char c) {
        if ( ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') )
            return true;
        else
            return false;
    }
}
