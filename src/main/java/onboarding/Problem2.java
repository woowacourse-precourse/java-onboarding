package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram.toString();
        while (isCryptogram(answer)) {
            boolean[] repeatCheck = new boolean[answer.length()];
            for (int i = 0; i < answer.length(); i++) {
                if (isRepeat(answer, i)) {
                    repeatCheck[i] = true;
                }
            }
            StringBuffer sb = new StringBuffer(answer);
            for (int i = repeatCheck.length-1; i >= 0; i--) {
                if (repeatCheck[i]) {
                    sb.deleteCharAt(i);
                }
            }
            answer = sb.toString();
        }
        return answer;
    }

    public static boolean isCryptogram(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRepeat(String str, int i) {
        if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
            return true;
        }
        if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
            return true;
        }
        return false;
    }
}

class Problem2First {
    public static String solution(String cryptogram) {
        String answer = cryptogram.toString();
        while (isCryptogram(answer)) {
            boolean[] repeatCheck = new boolean[answer.length()];
            for (int i = 0; i < answer.length(); i++) {
                if (i < answer.length() - 1 && answer.charAt(i) == answer.charAt(i + 1)) {
                    repeatCheck[i] = true;
                }
                if (i > 0 && answer.charAt(i) == answer.charAt(i - 1)) {
                    repeatCheck[i] = true;
                }
            }
            StringBuffer sb = new StringBuffer(answer);
            for (int i = repeatCheck.length-1; i >= 0; i--) {
                if (repeatCheck[i]) {
                    sb.deleteCharAt(i);
                }
            }
            answer = sb.toString();
        }
        return answer;
    }

    public static boolean isCryptogram(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

}

