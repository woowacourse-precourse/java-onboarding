package onboarding;

public class Problem2 {
    // 연속하는 중복 문자 제거
    private static String removeOverlap(String cryptogram) {
        String result = "";
        int cur = 0;
        char curChar;

        while (cur < cryptogram.length()) {
            if (cur == cryptogram.length() - 1 ||
                    cryptogram.charAt(cur) != cryptogram.charAt(cur + 1)) {
                result += cryptogram.charAt(cur);
                cur++;
            } else {
                curChar = cryptogram.charAt(cur);
                while (curChar == cryptogram.charAt(cur)) {
                    cur++;
                    if (cur == cryptogram.length()) {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int preLen = 0;

        while (answer.length() > 0) {
            preLen = answer.length();
            answer = removeOverlap(answer);
            if(answer.length() == preLen) {
                break;
            }
        }
        return answer;
    }
}
