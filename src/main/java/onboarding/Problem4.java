package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) ('A' + 'Z' - alphabet);
            } else if (alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char) ('a' + 'z' - alphabet);
            }
            answer.append(alphabet);
        }
        return answer.toString();
    }
}
