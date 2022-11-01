package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder(1000);

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if ('A' <= character && character <= 'Z') {
                answer.append((char) ('A' + 'Z' - character));
            } else if ('a' <= character && character <= 'z') {
                answer.append((char) ('a' + 'z' - character));
            } else {
                answer.append(character);
            }
        }
        return answer.toString();
    }
}