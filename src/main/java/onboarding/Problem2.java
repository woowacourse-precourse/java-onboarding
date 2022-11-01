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

    public static String removeRepetition(String cryptogram) {
        String result = "";
        int start = 0;
        int end = cryptogram.length();
        for (int i = 1; i < cryptogram.length(); ++i) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                start = i - 1;
                break;
            }
            for (int j = i + 1; j < cryptogram.length(); ++j) {
                if (cryptogram.charAt(j - 1) != cryptogram.charAt(j)) {
                    end = j;
                    break;
                }
            }
        }
        result += cryptogram.substring(0, start);
        if (end < cryptogram.length()) {
            result += cryptogram.substring(end);
        }
        return result;
    }
}
