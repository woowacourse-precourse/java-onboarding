package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            // 대문자일 경우
            if (ascii <= 90 && ascii >= 65) {
                // 앞쪽 문자
                if (ascii <= 77) {
                    answer += (char) (90 - (ascii - 65));
                }
                // 뒷쪽 문자
                else if (ascii >= 78) {
                    answer += (char) (65 + (90 - ascii));
                }
            }
            // 소문자일 경우
            else if (ascii <= 122 && ascii >= 97) {
                // 앞쪽 문자
                if (ascii <= 109) {
                    answer += (char) (122 - (ascii - 97));
                }
                // 뒷쪽 문자
                else if (ascii >= 110) {
                    answer += (char) (97 + (122 - ascii));
                }
            }
            // 띄어쓰기같은 알파벳이 아닌 문자
            else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }
}
