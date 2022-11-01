package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int N = cryptogram.length();
        // 1. 연속하는 중복 문자를 삭제한다.
        char prev = cryptogram.charAt(0);
        String res = cryptogram.substring(0, 1);
        for (int i = 1; i < N; i++){
            char now = cryptogram.charAt(i);
            if(prev != now){
                res += now;
            }
            else{
                res = res.substring(0, res.length()-1);
            }
            prev = now;
        }
        return answer;
    }
}