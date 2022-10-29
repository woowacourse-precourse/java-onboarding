package onboarding;

public class Problem4 {
    private static final int SUM_OF_ASCII_UPPER_A_AND_UPPER_Z = 155;
    private static final int SUM_OF_ASCII_LOWER_A_AND_LOWER_Z = 219;

    public static String solution(String word) {
        String answer = "";

       for(int i = 0; i<word.length();i++){
           char current = word.charAt(i);

            if(Character.isUpperCase(current))
                current = convertUpperCaseToSonFrogWord(current);
            else if(Character.isLowerCase(current))
                current = convertLowerCaseToSonFrogWord(current);

        answer+=current;
       }

        return answer;
    }

    private static char convertUpperCaseToSonFrogWord(char target){
        int targetToAscii = charToInt(target);
        int convertedAsciiSonFrogWord = SUM_OF_ASCII_UPPER_A_AND_UPPER_Z - targetToAscii;

        return (char)convertedAsciiSonFrogWord;
    }
    private static char convertLowerCaseToSonFrogWord(char target){
        int targetToAscii = charToInt(target);
        int convertedAsciiSonFrogWord = SUM_OF_ASCII_LOWER_A_AND_LOWER_Z - targetToAscii;

        return (char)convertedAsciiSonFrogWord;
    }

    private static int charToInt(char target){
        return (int) target;
    }

    private static char intToChar(int target){
        return (char) target;
    }
}
