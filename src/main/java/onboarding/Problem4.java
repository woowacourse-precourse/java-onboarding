package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i=word.length()-1; i>=0; i--) {
            answer.append(word.charAt(i));
        }

        return answer.toString();
    }
}
