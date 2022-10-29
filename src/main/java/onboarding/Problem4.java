package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

    // 대문자 변환
    static char uppercase(char a){
        char answer = (char)(155 - a);
        return answer;
    }
    // 소문자 변환
    static char lowercase(char a){
        char answer = (char)(219 - a);
        return answer;
    }
}
