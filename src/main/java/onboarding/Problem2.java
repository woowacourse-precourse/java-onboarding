package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        // cryptogram의 길이 제한
        String errorMessage = "Error";
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return errorMessage;
        }
        //cryptogram 소문자인지 판별
        String onlyLowerCase = "^[a-z]*$";
        if (!cryptogram.matches(onlyLowerCase)) {
            return errorMessage;
        }

        // cryptogram의 연속성확인을 통해 연속한 문자가 있으면 지운다
        while (consecutiveChecker(cryptogram)) {
            cryptogram = cryptogram.replaceAll("([a-z\\d])\\1", "");
        }

        answer = cryptogram;

        return answer;
    }

    // cryptogram의 연속성 확인
    public static boolean consecutiveChecker(String cryptogram) {
        char[] con = cryptogram.toCharArray();

        char prev = '\0';
        for (int i = 0; i < cryptogram.length(); i++) {
            if (con[i] == prev) {
                return true;
            }else prev = con[i];
        }

        return false;
    }
}