package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            int diff;
            char reversed = ' ';
            if (65 <= alphabet && alphabet <= 90) { // 소문자
                if (alphabet <= 77) {
                    diff = 77 - alphabet;
                    reversed = (char)(77 + diff + 1);
                }
                else {
                    diff = alphabet - 77;
                    reversed = (char)(77 - diff + 1);
                }
            }
            else if (97 <= alphabet && alphabet <= 122) { // 대문자
                if (alphabet <= 109) {
                    diff = 109 - alphabet;
                    reversed = (char)(109 + diff + 1);
                }
                else {
                    diff = alphabet - 109;
                    reversed = (char)(109 - diff + 1);
                }
            }
            answer += reversed;
        }
        return answer;
    }
}
