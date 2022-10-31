package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        //아스키코드를 이용하여 청개구리 사전 구현
        for (int i = 0; i < word.length(); i++){
            if ((int)word.charAt(i) >= 97 && (int)word.charAt(i) <= 122) {
                answer += (char)(219 - (int)word.charAt(i)); //소문자
            } else if ((int)word.charAt(i) >= 65 && (int)word.charAt(i) <= 90){
                answer += (char)(155 - (int)word.charAt(i)); //대문자
            } else {
                answer += word.charAt(i); //알파벳 외 문자
            }
        }
        return answer;
    }
}
