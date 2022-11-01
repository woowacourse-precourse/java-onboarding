package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder strb = new StringBuilder(word);

        for (int i = 0, wordLen = word.length(); i < wordLen; i++) {
            int currChar = (char) word.charAt(i);

            if (currChar >= 'A' && currChar <= 'Z') {
                currChar = 'A' + 'Z' - currChar;
                strb.setCharAt(i, (char) currChar);
            } else if (currChar >= 'a' && currChar <= 'z') {
                currChar = 'a' + 'z' - currChar;
                strb.setCharAt(i, (char) currChar);
            }
        }

        answer = strb.toString();
        return answer;
    }
}
