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
            if(c >= 65 && c <= 90) {
                appendChar = (char) (90 - c + 65);
            } else if (c >= 97 && c < 122) {
                appendChar = (char) (122 - c + 97);
            } else {
                appendChar = c;
            }
            sb.append(appendChar);
        }
        return sb.toString();
    }
}
