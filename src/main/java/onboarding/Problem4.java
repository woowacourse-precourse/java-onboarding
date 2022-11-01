package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++) {
            char word_ch = word.charAt(i);
            int word_int = (int)word_ch;

            if (word_int >= 65 && word_int <= 90) {
                answer += String.valueOf((char)(155 - word_int));
            }
            else if (word_int >= 97 && word_int <= 122) {
                answer += String.valueOf((char)(219 - word_int));
            }
            else {
                answer += word_ch;
            }
        }

        return answer;
    }
}
