package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (!isReturn(answer)) {
            answer = removeRepetition(answer);
        }

        return answer;
    }

    public static boolean isReturn(String cryptogram) {
        boolean isReturn = true;
        for (int i = 1; i < cryptogram.length(); ++i) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                isReturn = false;
                return isReturn;
            }
        }
        if (cryptogram == "") {
            isReturn = true;
        }
        return isReturn;
    }
}
