package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String alphabet = "";                   //후에 indexOf를 사용하기 위해 String으로 선언

        for(int i = 0; i < 26; i++){
            alphabet += (char) (65 + i);       //ASCII code를 char로 형변환하여 저장 (대문자)
        }

        for(int i = 0; i < 26; i++){
            alphabet += (char) (97 + i);       //소문자
        }

        return answer;
    }
}
