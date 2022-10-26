package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char character: word.toCharArray()) {
            answer.append(getOppositeLetter(character));
        }
        return answer.toString();
    }
}
