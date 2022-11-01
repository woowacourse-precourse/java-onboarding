package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }

    // 중복 문자 제거
    public static String removeStr(String str) {
        String answer = "";

        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i)==str.charAt(i+1))
                i++;
            else
                answer += str.charAt(i);
        }

        answer += str.charAt(str.length()-1);

        return answer;
    }
}
