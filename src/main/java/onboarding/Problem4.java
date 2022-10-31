package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }

    private static char getOppositeAlpha(char targetChar){
        int asciiOrder = targetChar - 'a';
        int convertOrder = 'z' - asciiOrder;

        char convertChar = (char)convertOrder;
        System.out.println(convertChar);
        return convertChar;
    }
}
