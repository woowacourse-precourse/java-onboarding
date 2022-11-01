package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch))
                answer += (char) ((int) 'Z' + (int) 'A' - (int) ch);
            else if (Character.isLowerCase(ch))
                answer += (char) ((int) 'z' + (int) 'a' - (int) ch);
            else
                answer += ch;
        }

        return answer;
    }
}
