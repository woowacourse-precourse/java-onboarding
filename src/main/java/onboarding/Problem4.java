package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length();i++){
            int ascii_num = word.charAt(i);
            if (65 <= ascii_num && ascii_num <= 90) {
                ascii_num = 155 - ascii_num;
            } else if (97 <= ascii_num && ascii_num <= 122) {
                ascii_num = 219 - ascii_num;
            }
            answer += (char) ascii_num;
        }
        return answer;
    }
}
