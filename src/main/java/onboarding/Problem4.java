package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // 청개구리 사전에 맞게 문자를 반대로 변환하는 함수
    public static String changeWord(char before) {
        String[] changeWord = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B",	"A"};

        if(97 <= before && before <= 122) { // 소문자일 경우
            before -= 32;
            String beforeWord = Character.toString(before);
            int index = Arrays.asList(changeWord).indexOf(beforeWord);
            return changeWord[changeWord.length - index -1].toLowerCase();
        }

        String beforeWord = Character.toString(before);
        int index = Arrays.asList(changeWord).indexOf(beforeWord);

        if (index == -1) { // 알파벳이 아닌 경우
            return beforeWord;
        }

        return changeWord[changeWord.length - index -1];
    }
}
