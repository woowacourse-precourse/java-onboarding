package onboarding;

public class Problem4 {
    static String changeWord(String word) {
        char[] wordArr = word.toCharArray();
        int arrLength = wordArr.length;
        for(int i = 0; i < arrLength; i++) {
            if(wordArr[i] == 32) {
                continue;
            }
            if(65 <= wordArr[i] && wordArr[i] <= 90) {
                wordArr[i] = (char)(155 - wordArr[i]);
                continue;
            }
            if(97 <= wordArr[i] && wordArr[i] <= 122) {
                wordArr[i] = (char)(219 - wordArr[i]);
            }

        }
        return new String(wordArr);
    }
    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }
}
