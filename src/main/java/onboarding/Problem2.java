package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    
    private static String removeDuplicate(String word) {

        char recentChar = 0;
        boolean isRemoved = false;

        for (int i = 0; i < word.length(); i++) {
            if (i != 0 && recentChar == word.charAt(i)) {
                int start = i - 1;
                int end = findEndPoint(word, start);
                word = word.substring(0, start) + word.substring(end);
                isRemoved = true;
                break;
            }
            recentChar = word.charAt(i);
        }

        if (isRemoved) {
            word = removeDuplicate(word);
        }

        return word;
    }

}
