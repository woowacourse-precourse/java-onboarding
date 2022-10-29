package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /*
    중복 문자가 있으면 true
    없으면 false 반환
     */
    public static boolean checkString(String cryptogram) {
        int n = cryptogram.length();
        for (int i = 0; i < n-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
