package onboarding;

/**
 * 제한 사항
 * 1. 알파벳 외 문자는 변환 x
 * 2. 대문자는 대문자 , 소문자는 소문자
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        /**
         * 알파벳은  a + n , A + n (0<=n<=25) 으로 표현할 수 있음을 이용.
         * 기존 알파벳 + 역순 알파벳 =  2a + 25 또는 2A + 25
         * 따라서 역순 알파벳 = 2a - 기존 알파벳을 구함.
         */
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<word.length();i++) {
            char cur = word.charAt(i);
            if(cur >= 'a' && cur <='z'){
                int temp = 2 *'a' + 25;
                sb.append((char)(temp - cur));
            }
            else if(cur >='A' && cur <='Z'){
                int temp = 2 *'A' + 25;
                sb.append((char)(temp - cur));
            }
            else sb.append(cur);
        }
        answer = sb.toString();
        return answer;
    }
}
