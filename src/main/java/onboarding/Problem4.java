package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if (ascii <= 90 && ascii >= 65) {
                if (ascii <= 77) {
                    answer += (char) (90 - (ascii - 65));
                } else if (ascii >= 78) {
                    answer += (char) (65 + (90 - ascii));
                }
            } else if (ascii <= 122 && ascii >= 97) {
                if (ascii <= 109) {
                    answer += (char) (122 - (ascii - 97));
                } else if (ascii >= 110) {
                    answer += (char) (97 + (122 - ascii));
                }
            } else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }
}
