package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.charAt(i);
        }
        for (char c : arr) {
            if (lowerCase(c)) {
                answer += (char) ('a' + 'z' - c);
            } else if (upperCase(c)) {
                answer += (char) ('A' + 'Z' - c);
            } else {
                answer += " ";
            }
        }

        return answer;
    }

    static boolean lowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    static boolean upperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
