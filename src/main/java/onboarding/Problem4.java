package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i = 0; i < word.length(); i++) {
            char tmpCh = word.charAt(i);
            tmpCh = changeWord(tmpCh);
            answer += tmpCh;
        }

        return answer;
    }

    static char changeWord(char word) {
        char newWord = 0;
        int wordValue = (int)word;

        if(65 <= wordValue && wordValue <= 77) {
            newWord = (char)(wordValue + (Math.abs(77-wordValue)*2 + 1));
        }else if(78 <= wordValue && wordValue <= 90) {
            newWord = (char)(wordValue - (Math.abs(78-wordValue)*2 + 1));
        } else if(97 <= wordValue && wordValue <= 109) {
            newWord = (char)(wordValue + (Math.abs(109-wordValue)*2 + 1));
        } else if(110 <= wordValue && wordValue <= 122) {
            newWord = (char)(wordValue - (Math.abs(110-wordValue)*2 + 1));
        } else {
            newWord = word;
        }

        return newWord;
    }
}
