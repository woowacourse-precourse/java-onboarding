package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while(true) {
            String removeString = removeWord(answer);

            // 중복 문자를 모두 제거 하는 순간 반복문 탈출
            if(answer.equals(removeString)) { break; }

            // 중복 문자 제거를 반복하며 결과 저장
            answer = removeString;
        }

        return answer;
    }

    // 중복 문자 제거
    private static String removeWord(String s) {
        String result = "";

        for(int i = 0; i < s.length(); i++) {
            char now_char = s.charAt(i);

            // 현재 문자와 바로 이전 문자가 같다면 저장하지 않음
            if(i > 0 && (now_char == s.charAt(i-1))) {
                continue;
            } // 현재 문자와 바로 다음 문자가 같다면 저장하지 않음
            else if((i + 1 < s.length()) && (now_char == s.charAt(i+1))) {
                continue;
            }

            // 현재 문자와 바로 앞뒤 문자가 다른 경우에만 저장
            result += now_char;
        }

        return result;
    }
}
