package onboarding;

public class Problem4 {
    private static final int SUM_OF_ASCII_UPPER_A_AND_UPPER_Z = 155;
    private static final int SUM_OF_ASCII_LOWER_A_AND_LOWER_Z = 219;

    public static String solution(String word) {
        String answer = "";

       for(int i = 0; i<word.length();i++){
           char current = word.charAt(i);

           // 알파벳만 변환하며 대문자는 대문자로, 소문자는 소문자로 변환.

            if(Character.isUpperCase(current)) // upper case인 경우
                current = convertUpperCaseToSonFrogWord(current);
            else if(Character.isLowerCase(current)) // lower case인 경우
                current = convertLowerCaseToSonFrogWord(current);

        answer+=current;
       }
        return answer;
    }

    /**
     * Upper case 청개구리 언어 변환
     * @param target
     * @return converted char
     */
    private static char convertUpperCaseToSonFrogWord(char target){
        int targetToAscii = charToInt(target);
        int convertedAsciiSonFrogWord = SUM_OF_ASCII_UPPER_A_AND_UPPER_Z - targetToAscii;

        return (char)convertedAsciiSonFrogWord;
    }

    /**
     * Lower case 청개구리 언어 변환
     * @param target
     * @return converted char
     */
    private static char convertLowerCaseToSonFrogWord(char target){
        int targetToAscii = charToInt(target);
        int convertedAsciiSonFrogWord = SUM_OF_ASCII_LOWER_A_AND_LOWER_Z - targetToAscii;

        return (char)convertedAsciiSonFrogWord;
    }

    /**
     *
     * Target char를 ascii로 변환
     * @param target
     * @return ascii
     */
    private static int charToInt(char target){
        return (int) target;
    }

    /**
     * Target ascii를 char로 변환
     * @param target
     * @return char
     */
    private static char intToChar(int target){
        return (char) target;
    }
}
