package onboarding;

public class Problem2 {
    // 연속하는 중복 문자 제거
    private static String removeOverlap(String crypt) {
        String result = "";
        int cur = 0;
        char curChar;

        while (cur < crypt.length()) {
            if (cur == crypt.length() - 1 ||
                    crypt.charAt(cur) != crypt.charAt(cur + 1)) {
                result += crypt.charAt(cur);
                cur++;
            } else {
                curChar = crypt.charAt(cur);
                while (curChar == crypt.charAt(cur)) {
                    cur++;
                    if (cur == crypt.length()) {
                        break;
                    }
                }
            }
        }
    }

    public static String solution(String crypt) {
        String answer = crypt;
        int preLen = 0;

        while (answer.length() > 0) {
            preLen = answer.length();
            answer = removeOverlap(answer);
            if(answer.length() == preLen) {
                break;
            }
        }
    }
}
