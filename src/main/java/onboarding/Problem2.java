package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (existRepeat(answer)) {
            answer = deleteRepeatWords(answer);
        }
        return answer;
    }

    public static String repeatWords(String s) {
        String repeat = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                repeat = String.valueOf(s.charAt(i - 1)) + String.valueOf(s.charAt(i));
            }
        }
        return repeat;
    }

    public static String deleteRepeatWords(String s) {
        return s.replace(repeatWords(s), "");
    }

    public static boolean existRepeat(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
