package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char one = word.charAt(i);
            if ('a' <= one && one <= 'z') {//소문자인 경우
                one = (char) ('z' - one + 'a');
            } else if('A' <= one && one <= 'Z'){//대문자인 경우
                one = (char) ('Z' - one + 'A');
            } else{ //그 외의 문자
            }
            sb.append(one);
        }
        answer = sb.toString();
        return answer;
    }
}
