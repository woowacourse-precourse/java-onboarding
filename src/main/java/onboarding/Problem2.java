package onboarding;

public class Problem2 {
    private static int isDuplicate(char first, char second) {
        if (first == second)
            return 1;
        return 0;
    }

    private static boolean checkSentence(String sentence) {
        int sum = 0;
        for (int i = 0; i < sentence.length() - 1; i++) {
            sum += isDuplicate(sentence.charAt(i), sentence.charAt(i+1));
        }
        return sum <= 0;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
