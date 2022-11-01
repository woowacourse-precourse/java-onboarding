package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordCopy = word.toCharArray();
        int[] wordCopyNum = new int[word.length()];

        for (int i = 0; i < wordCopy.length;  i++) {
            wordCopyNum[i] = (int)wordCopy[i];
        }

        for (int i = 0; i < wordCopyNum.length; i++) {
            if (wordCopyNum[i] >= 65 && wordCopyNum[i] <= 90) wordCopyNum[i] = 155-wordCopyNum[i];
            if (wordCopyNum[i] >= 97 && wordCopyNum[i] <= 122) wordCopyNum[i] = 219-wordCopyNum[i];
        }

        for (int i = 0; i < wordCopyNum.length; i++) {
            wordCopy[i] = (char)wordCopyNum[i];
        }

        answer = String.valueOf(wordCopy);
        return answer;
    }
}
