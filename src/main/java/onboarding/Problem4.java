package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //1. word 한 글자씩 읽음.
        //  2. 알파벳이 소문자이면(아스키 코드 97~121) 122-(알파벳-97)
        //  3. 알파벳이 대문자이면(아스키 코드 65~90) 90-(알파벳-65)
        //  4. 공백일 때는 answer에 공백 넣어주고 continue
        for(int i=0;i<word.length();i++) {
            int asci = word.charAt(i);
            if (asci > 96) answer += Character.toString((char) 219 - asci);
        }
        return answer;
    }
}
