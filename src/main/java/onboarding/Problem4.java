package onboarding;

public class Problem4 {


    public static String solution(String word) {
        String answer = "";
        char[] letters = word.toCharArray();
        int strLen = word.length();

        for (int i = 0; i < strLen; i++) {
            if (letters[i] == ' ')
                answer += " ";

            else if (Character.isUpperCase(letters[i]))
                answer += (char) (155 - (int) letters[i]);

            else
                answer += (char) (219 - (int) letters[i]);
        }

        return answer;
    }
}
