package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int wordLen = word.length();
        for(int i = 0; i < wordLen; ++i){
            char curChar = word.charAt(i);
            if(Character.isLetter(curChar)) {
                char leftStandard = setStandard(curChar, "left");
                char rightStandard = setStandard(curChar, "right");
                boolean inLeft = isInLeft(curChar, leftStandard);

            }
        }
        return answer;
    }

    public static char setStandard(char c, String domain) {
        char standard = 'm';
        if(Character.isUpperCase(c))
            standard = 'M';
        if(domain.equals("right"))
            standard = (char) (standard + 1);
        return standard;
    }

    public static boolean isInLeft(char c, char leftStandard) {
        if(c <= leftStandard)
            return true;
        return false;
    }
}
