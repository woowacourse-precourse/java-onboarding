package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static String clearString(String answer) {

        char[] chars = answer.toCharArray();
        char previous = 0;
        int k = 0;

        for (char c : chars) {
            if (previous != c) {
                chars[k++] = c;
                previous = c;
            }
        }

        return new String(chars).substring(0, k);
    }
}
