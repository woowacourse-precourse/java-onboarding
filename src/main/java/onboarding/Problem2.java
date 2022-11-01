package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        // 2. 중복 문자가 없을 때까지 반복한다.
        while(true) {
            int N = cryptogram.length();
            int f = 0;
            if(N==0){
                break;
            }
            // 1. 연속하는 중복 문자를 삭제한다.
            char prev = cryptogram.charAt(0);
            String res = cryptogram.substring(0, 1);
            for (int i = 1; i < N; i++) {
                char now = cryptogram.charAt(i);
                if (prev != now) {
                    res += now;
                } else {
                    res = res.substring(0, res.length() - 1);
                    f = 1;
                }
                prev = now;
            }
            cryptogram = res;
            // 중복이 없는 상태
            if (f!=1){
                break;
            }
        }
        return cryptogram;
    }
}