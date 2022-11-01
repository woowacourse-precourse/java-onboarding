package onboarding;

public class Problem4 {
    public static String solution(String word) {

        // 예외 처리
        if (word.length() < 1 || word.length() > 10000) {
            return "제한사항 위반";
        } else if (word.matches("^[a-zA-Z]*$")) {
            return "제한사항 위반";
        }


        String answer = "";

        for (int i=0; i<word.length(); i++) {
            answer += reverse(word.charAt(i));
        }

        return answer;
    }

    // 알파벳 변환
    public static char reverse(char c) {
        // 대소문자 구분
        if (Character.isUpperCase(c)) {
            return (char) (90 - c + 65);
        } else if (Character.isLowerCase(c)) {
            return (char) (122 - c + 97);
        } else {
            return c;
        }
    }
}
