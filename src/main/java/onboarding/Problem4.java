package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c))
                    c = (char)((int)'A' + (int)'Z' - (int)c);
                else
                    c = (char)((int)'a' + (int)'z' - (int)c);
            }
            answer += c;
        }

        return answer;
    }
}
