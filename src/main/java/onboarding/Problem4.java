package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int upBase = 'A' + 'Z';
        int lowBase = 'a' + 'z';

        for (int i = 0; i < word.length(); i++) {
            char myChar = word.charAt(i);

            if (myChar >= 'A' && myChar <= 'Z') {
                myChar = (char)(upBase - myChar);
            } else if (myChar >= 'a' && myChar <= 'z') {
                myChar = (char)(lowBase - myChar);
            }
            answer += myChar;
        }
        return answer;
    }
}
