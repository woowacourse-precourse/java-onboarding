package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            char tar = word.charAt(i);
            if ('A' <= tar && tar <= 'Z') {
                result += Character.toString('A' + 'Z' - tar);
                continue;
            }
            if ('a' <= tar && tar <= 'z') {
                result += Character.toString('a' + 'z' - tar);
                continue;
            }
            result += tar;
        }

        return result;
    }
}
