package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int operation = 0;
        char[] wordChars = word.toCharArray();

        for (char ch: wordChars) {
            if (ch == 32) {
                answer += " ";
            }

            if (ch >= 65 && ch <= 97) {
                operation = (65 - (int) ch) + (90 - (int) ch);
                ch += operation;

                answer += ch;
            }

            if (ch >= 97 && ch <= 122) {
                operation = (97 - (int) ch) + (122 - (int) ch);
                ch += operation;

                answer += ch;
            }
        }

        return answer;
    }
}