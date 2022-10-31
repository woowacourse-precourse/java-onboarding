package onboarding;

public class Problem2 {
    private static boolean isDuplication(String str) {
        if (str == "")
            return false;

        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (tmp == cur) {
                return true;
            }
            tmp = cur;
        }
        return false;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
