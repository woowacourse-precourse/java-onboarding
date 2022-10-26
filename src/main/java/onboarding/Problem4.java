package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length(); i++) {
            int ascii_val = (int)word.charAt(i);
            int new_alphabet = ascii_val;
            if ((65<= ascii_val && ascii_val <=90)) {
                new_alphabet = 155-ascii_val;
            } else if ((97<= ascii_val && ascii_val <=122)) {
                new_alphabet = 219-ascii_val;
            }
            answer += String.valueOf((char)new_alphabet);
        }
        return answer;
    }
}
