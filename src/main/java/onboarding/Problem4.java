package onboarding;

import problem4.TranslateChar;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        TranslateChar translateChar = new TranslateChar();

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            answer += translateChar.translateChar(c);
        }

        return answer;
    }

}
