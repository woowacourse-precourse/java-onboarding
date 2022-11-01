package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            int indexChar = word.charAt(index);
            if (indexChar >= 65 && indexChar <= 77)
                indexChar = 90 - (indexChar - 65);
            else if (indexChar >= 78 && indexChar <= 90)
                indexChar = 65 + (90 - indexChar);
            else if (indexChar >= 97 && indexChar <= 109)
                indexChar = 122 - (indexChar - 97);
            else if (indexChar >= 110 && indexChar <= 122)
                indexChar = 97 + (122 - indexChar);
            answer.append((char)indexChar);
        }
        return answer.toString();
    }
}
