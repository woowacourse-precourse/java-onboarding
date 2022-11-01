package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0;i<word.length();i++){
            if (word.charAt(i) >= 'a' && word.charAt(i) <='Z'){
                answer += (char)('A' + 'Z' - word.charAt(i));
            }
            else {
                answer += (char)word.charAt(i);
            }
        }
        return answer;
    }
}
