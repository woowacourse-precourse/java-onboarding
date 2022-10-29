package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String alphabet = "";                   //후에 indexOf를 사용하기 위해 String으로 선언
        char[] frog = new char[52];

        for(int i = 0; i < 26; i++){
            alphabet += (char) (65 + i);       //ASCII code를 char로 형변환하여 저장 (대문자)
            frog[i] = (char) (90 - i);         //알파벳 순서 반대로 저장
        }

        for(int i = 0; i < 26; i++){
            alphabet += (char) (97 + i);       //소문자
            frog[i + 26] = (char) (122 - i);
        }

        return answer;
    }
}
