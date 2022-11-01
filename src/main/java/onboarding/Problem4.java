package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return convertStr(word);
    }

    private static char convertChar(char singleChr){
        int charAsci = singleChr;
        int convertedCharAsci = 0;

        if(charAsci >= (int)'a')
            convertedCharAsci = (int)'z' - (charAsci - (int)'a');
        else
            convertedCharAsci = (int)'Z' - (charAsci - (int)'A');

        return (char)convertedCharAsci;
    }

    private static boolean isAlphabet(char singleChar){
        if ((singleChar >= 'A' && singleChar <= 'Z') || (singleChar >= 'a' && singleChar <= 'z'))
            return true;
        else
            return false;
    }
    private static String convertStr(String origin){
        char[] charArr = origin.toCharArray();
        for(int i=0; i<charArr.length; i++){
            if(isAlphabet(charArr[i]))
                charArr[i] = convertChar(charArr[i]);
        }
        return String.valueOf(charArr);
    }
}
