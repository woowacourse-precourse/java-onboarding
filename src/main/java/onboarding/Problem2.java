package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length() == 1)
            return cryptogram;
        String answer = "answer";
        return answer;
    }

    public static int duplicationCount(String str, int start) {
        int cnt = 0;
        while (start < str.length() - 1 && str.charAt(start) == str.charAt(start + 1)) {
            cnt += 1;
            start += 1;
        }
        return cnt;
    }
}
