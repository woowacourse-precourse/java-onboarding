package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (c >= 65 && c <= 90){ // 대문자 아스키코드 범위
                int index = 90 - c;
                char tmp = alpha.charAt(index);
                tmp = Character.toUpperCase(tmp);
                answer += tmp;
            }
            else if (c >= 97 && c <= 122){ // 소문자 아스키코드 범위
                int index = 122 - c;
                char tmp = alpha.charAt(index);
                answer += tmp;
            }
            else{ // 그 외
                answer += c;
            }
        }


        return answer;
    }
}
