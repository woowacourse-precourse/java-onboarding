package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            char now_char = word.charAt(i);
            // 알파벳 소문자면 청개구리 사전 참고하여 반대로 변환한 대문자 넣기
            if(now_char >= 'a' && now_char <= 'z') {
                now_char = (char) ('z' - now_char + 'a');
                answer += now_char;
            } // 알파벳 대문자면 청개구리 사전 참고하여 반대로 변환한 소문자 넣기
            else if(now_char >= 'A' && now_char <= 'Z') {
                now_char = (char) ('Z' - now_char + 'A');
                answer += now_char;
            } // 알파벳이 아니면 그대로 넣기
            else {
                answer += now_char;
            }

        }
        return answer;
    }
}
