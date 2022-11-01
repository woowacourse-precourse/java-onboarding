package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArr = word.toCharArray();

        for (int i = 0; i < wordArr.length; i++) {
            int alphabet = (int) wordArr[i];
            if (alphabet >= 65 && alphabet <= 90) {
                alphabet = 155 - alphabet;
            } else if (alphabet >= 96 && alphabet <= 122) {
                alphabet = 219 - alphabet;
            }
            wordArr[i] = (char) alphabet;
        }

        word = new String(wordArr);

        answer = word;

        return answer;
    }
}
