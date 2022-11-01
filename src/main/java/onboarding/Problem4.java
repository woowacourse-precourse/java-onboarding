package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();
        answer = reverseString(wordArray);

        return answer;
    }

    private static String reverseString(char[] wordArray) {
        String newWord = "";
        for (int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            if (c >= 'A' && c <= 'Z') {
                wordArray[i] = (char) (155 - wordArray[i]);
            } else if (c >= 'a' && c <= 'z') {
                wordArray[i] = (char) (219 - wordArray[i]);
            }
            newWord += wordArray[i];
        }
        return newWord;
    }


}
