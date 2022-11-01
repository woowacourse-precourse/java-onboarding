package onboarding;

public class Problem4 {
    /**
     * 문자열 거꾸로 반환
     * @param word
     * @return backward word
     */
    public static String solution(String word) {
        String answer = "";
        if(word.isEmpty() || word.length() > 1000) // word 길이 에러처리
            return "word length error";

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!Character.isAlphabetic(c)) // 알파벳 외의 문자는 변환하지 않음
                answer += (char)c;
            else if(Character.isUpperCase(c)) // 알파벳 대문자
                answer += (char)('Z'-c+'A') ;
            else // 알파벳 소문자
                answer += (char)('z'-c+'a');
        }
        return answer;
    }
}
