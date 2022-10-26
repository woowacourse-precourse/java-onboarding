package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public String removeDuplicateLetters(String str) {
        String removedStr = str;
        for(char i = 'a'; i <= 'z'; i++) {
            removedStr = removedStr.replaceAll(i + "{2,}", " ");
        }
        removedStr = removedStr.replaceAll(" ", "");
        return removedStr;
    }
}
