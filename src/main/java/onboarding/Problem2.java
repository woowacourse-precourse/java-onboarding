package onboarding;

/* 기능 목록
 *
 *  removeCont : 문자열에서 연속되는 문자를 제거
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while(true) {
            String removeStr = removeCont(answer);

            if(answer.equals(removeStr))
                break;
            answer = removeStr;
        }

        return answer;
    }

    private static String removeCont(String s) {
        String result = "";

        for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if(i > 0 && now == s.charAt(i-1))
                continue;
            else if(i + 1 < s.length() && now == s.charAt(i+1))
                continue;

            result += now;
        }

        return result;
    }
}
