package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static StringBuilder changeToStringBuilder(String crpytogram) {
        StringBuilder stringBuilder = new StringBuilder(crpytogram);
        return stringBuilder;
    }

    private static boolean isDuplicate(StringBuilder cryptogram, int index) {
        if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
            return true;
        }
        return false;
    }
}
