package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean checkDuplicatedAndDelete(StringBuilder input) {
        boolean chk = false;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                input.deleteCharAt(i);
                input.deleteCharAt(i);
                i--;
                chk = true;
            }
        }
        return chk;
    }
}