package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int size = word.length();

        for (int i = 0; i < size; i++) {
            char c = word.charAt(i);
            char replacedC;
            if(c >= 65 && c <= 90) replacedC = (char) (90 + 65 - c);
            else if(c >= 97 && c <= 122) replacedC = (char) (122 + 97 - c);
            else replacedC = c;
            answer = answer.concat(String.valueOf(replacedC));
        }
        return answer;
    }
}
