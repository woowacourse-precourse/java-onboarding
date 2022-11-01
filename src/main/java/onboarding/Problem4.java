package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = changeReverse(word);
        return answer;
    }
    public static String changeReverse(String word) {
        char[] tempWordArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int wordArrayNum = tempWordArray[i];
            if (65 <= wordArrayNum && wordArrayNum <= 90) {
                wordArrayNum = (90 - (wordArrayNum - 65));
            } else if (97 <= wordArrayNum && wordArrayNum <= 122) {
                wordArrayNum = (122 - (wordArrayNum - 97));
            }
            tempWordArray[i] = (char) wordArrayNum;
        }
        word = String.valueOf(tempWordArray);
        return word;
    }
}
