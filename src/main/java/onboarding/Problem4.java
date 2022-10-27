package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char ch : word.toCharArray()) {
            answer += changeWord(ch);
        }

        return answer;
    }

    static char changeWord(char word) {
        char newWord = 0;
        int wordValue = word;

        if(65 <= wordValue && wordValue <= 77) {            // [a-m]
            newWord = (char)(wordValue + (Math.abs(77-wordValue)*2 + 1));
        }else if(78 <= wordValue && wordValue <= 90) {      // [n-z]
            newWord = (char)(wordValue - (Math.abs(78-wordValue)*2 + 1));
        } else if(97 <= wordValue && wordValue <= 109) {    // [A-M]
            newWord = (char)(wordValue + (Math.abs(109-wordValue)*2 + 1));
        } else if(110 <= wordValue && wordValue <= 122) {   // [N-Z]
            newWord = (char)(wordValue - (Math.abs(110-wordValue)*2 + 1));
        } else {                                            // 알파벳 외의 문자
            newWord = word;
        }

        return newWord;
    }
}
