package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordCopy = word.toCharArray();
        int[] wordCopyNum = new int[word.length()];

        for (int i = 0; i < wordCopy.length;  i++) {
            wordCopyNum[i] = (int)wordCopy[i];
        }


        return answer;
    }
}
