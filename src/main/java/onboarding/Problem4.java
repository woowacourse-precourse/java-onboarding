package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        //대문자 아스키 코드 65~90
        //소문자 아스키 코드 97~122
        ArrayList<Integer> stringToAsciiCodes = new ArrayList<>();
        ArrayList<Integer> codeForAnswerString = new ArrayList<>();
        ArrayList<String> answerStringArray = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            stringToAsciiCodes.add((int)word.toCharArray()[i]);
        }

        for (Integer stringToAsciiCode : stringToAsciiCodes) {
            if (96 < stringToAsciiCode && stringToAsciiCode < 123) {
                codeForAnswerString.add(219 - stringToAsciiCode);
            } else if (64 < stringToAsciiCode && stringToAsciiCode < 91) {
                codeForAnswerString.add(155 - stringToAsciiCode);
            } else {
                codeForAnswerString.add(stringToAsciiCode);
            }
        }

        for (Integer integer : codeForAnswerString) {
            String answerChar = Character.toString((char) Integer.parseInt(String.valueOf(integer)));
            answerStringArray.add(answerChar);
        }

        return String.join("",answerStringArray);
    }
}
