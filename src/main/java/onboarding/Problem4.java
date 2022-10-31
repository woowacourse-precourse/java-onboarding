package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            answer.append(getOppositeAlpha(word.charAt(i)));
        }

        return answer.toString();
    }

    private static char getOppositeAlpha(char targetChar){
        char returnChar;

        if (Character.isAlphabetic(targetChar)){
            if (Character.isUpperCase(targetChar)){
                returnChar = getUpperCharOppositeAlpha(targetChar);
            } else {
                returnChar = getLowerOppositeAlpha(targetChar);
            }
        } else {
            returnChar = ' ';
        }
        return returnChar;
    }

    private static char getUpperCharOppositeAlpha(char targetChar){
        int asciiOrder = targetChar - 'A';
        int convertOrder = 'Z' - asciiOrder;

        char convertChar = (char)convertOrder;
        return convertChar;
    }

    private static char getLowerOppositeAlpha(char targetChar){
        int asciiOrder = targetChar - 'a';
        int convertOrder = 'z' - asciiOrder;

        char convertChar = (char)convertOrder;
        return convertChar;
    }
}
