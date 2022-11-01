package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder wordB = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            int currChar = (char) word.charAt(i);

            if (currChar >= 'A' && currChar <= 'Z') {
                currChar = 'A' + 'Z' - currChar;
                wordB.setCharAt(i, (char) currChar);
            } else if (currChar >= 'a' && currChar <= 'z') {
                currChar = 'a' + 'z' - currChar;
                wordB.setCharAt(i, (char) currChar);
            }
        }

        answer = wordB.toString();
        return answer;
    }
}