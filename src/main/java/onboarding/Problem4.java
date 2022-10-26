package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";



        return answer;
    }

    /**
     * 기능 1
     * String을 청개구리 사전으로 변환 하는 기능
     */

    public static String translateString(String word) {
        String translatedString = "";

        for(int i = 0; i < word.length(); i++)
        {
            if (checkAlphabet(word.charAt(i))) {
                translatedString += translateChar(word.charAt(i));
            }else
            {
                translatedString += word.charAt(i);
            }
        }

        return translatedString;
    }

    /**
     * 기능 2
     * 알파벳인지 아닌지를 구분하는 기능
     */
    public static boolean checkAlphabet(char ch) {

        if( (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))
            return true;

        return false;
    }

    /**
     * 기능 3
     * 알파벳 하나를 변환 하는 기능
     */
    public static char translateChar(char ch) {
        char translatedCharacter = ' ';

        return translatedCharacter;
    }


}
