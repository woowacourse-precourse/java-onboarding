package onboarding;

public class Problem4 {
    private static char convertLetter(char alpha) {
        if (alpha >= 'A' && alpha <= 'Z') {
            return (char) ('A' + 'Z' - alpha);
        }
        if (alpha >= 'a' && alpha <= 'z') {
            return (char) ('a' + 'z' - alpha);
        }
        return alpha;
    }

    private static String convertSentence (String sentence) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            tmp.append(convertLetter(sentence.charAt(i)));
        }
        return tmp.toString();
    }

    public static String solution(String word) {
        String answer = "";
        answer = convertSentence(word);
        return answer;
    }
}
