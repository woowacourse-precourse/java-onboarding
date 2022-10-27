package onboarding;

public class Problem4 {
    private static final char[] ENCODING_UPPER_CASE = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

    private static final char[] ENCODING_LOWER_CASE = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                answer += ENCODING_UPPER_CASE[word.charAt(i) - 65];
                continue;
            }

            if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                answer += ENCODING_LOWER_CASE[word.charAt(i) - 97];
                continue;
            }

            answer += word.charAt(i);
        }

        return answer;
    }
}
