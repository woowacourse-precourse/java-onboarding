package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        StringBuilder str = new StringBuilder();
        for ( int i = 0 ; i < word.length(); i++) {
            int j = word.charAt(i);
            if (j >= 65 && j <= 90) {
                j = 155 - j;
            } else if (j >= 97 && j <= 122) {
                j = 219 - j;
            }
            str.append((char) j);
        }
        answer = str.toString();

        return answer;
    }
}
