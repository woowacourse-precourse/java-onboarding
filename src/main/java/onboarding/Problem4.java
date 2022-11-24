package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        word.chars().
                forEach(x -> answer.append(converter((char)x)));
        return answer.toString();
    }

    private static char converter(char ch) {
        if (Character.isAlphabetic(ch)) {
            return Character.isUpperCase(ch) ? (char)(155 - ch) : (char)(219 - ch);
        }
        return ch;
    }
}
