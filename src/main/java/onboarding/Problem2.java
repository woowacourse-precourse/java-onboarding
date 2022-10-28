package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean checkingCode(String cryptogram) {
        String[] code = cryptogram.split("");
        for (int i = 0; i < code.length - 1; i++) {
            if (code[i] == code[i + 1]) {
                return true;
            }
        }

        return false;
    }

}
