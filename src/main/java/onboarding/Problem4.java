package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] wordList = word.toCharArray();
        int reverse, temp, ascii = 0;


        for(int i = 0; i < wordList.length;i++) {
            if(Character.isUpperCase(wordList[i])) {
                ascii = 65;
            } else if(Character.isLowerCase(wordList[i])) {
                ascii = 97;
            } else {
                answer = answer + ' ';
                continue;
            }
            temp = Math.abs(ascii - wordList[i]);
            reverse = (ascii + 25) - temp;
            answer = answer + String.valueOf((char)reverse);
        }

        return answer;
    }
}
