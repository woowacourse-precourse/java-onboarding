package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++) {
            char word_check = word.charAt(i);
            if(word_check >= 65 && word_check <= 90) {
                answer += (char)(155-word.charAt(i));
            } else if(word_check >= 97 && word_check <= 122) {
                answer += (char)(219-word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }
}
