package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = treeFrog(word);
        return answer;
    }

    private static String treeFrog(String word) {
        char appendChar;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()) {
            if(c >= 'A' && c <= 'Z') {
                appendChar = (char) ('Z' - c + 'A');
            } else if (c >= 'a' && c < 'z') {
                appendChar = (char) ('z' - c + 'a');
            } else {
                appendChar = c;
            }
            sb.append(appendChar);
        }
        return sb.toString();
    }
}
