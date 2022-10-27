package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        boolean isDuplicated = false;
        while (true) {
            for (int i = 0; i < cryptogram.length(); i++) {
                int duplicateCount = checkDuplicate(cryptogram, i);
            }
            if(!isDuplicated) break;
        }

        return answer;
    }

    private static int checkDuplicate(String cryptogram, int idx) {
        char c = cryptogram.charAt(idx);
        int cnt = 1;
        for (int i = idx + 1; i < cryptogram.length(); i++) {
            if(c == cryptogram.charAt(i)) cnt += 1;
            else {
                if(i == idx) cnt = -1;
                break;
            }
        }
        return cnt;
    }
}
