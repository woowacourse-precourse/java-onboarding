package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            int ascii_char = word.charAt(i);
            if(ascii_char >= 97 && ascii_char <= 122) {
                ascii_char = 122 - (ascii_char - 97);
            }
            else if(ascii_char >= 65 && ascii_char <= 90) {
                ascii_char = 90 - (ascii_char - 65);
            }
            answer += (char)ascii_char;
        }
        return answer;
    }
}
