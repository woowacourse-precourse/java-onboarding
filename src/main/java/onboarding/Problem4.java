package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++){
            int tmp = (int) word.charAt(i);
            if(65 <= tmp && tmp <= 90) { // 알파벳 소문자
                answer += (char)(155 - tmp);
            }
            else if(97 <= tmp && tmp <= 122) { // 알파벳 대문자
                answer += (char)(219 - tmp);
            }
            else { // 그 외
                answer += (char)tmp;
            }
        }
        return answer;
    }
}
