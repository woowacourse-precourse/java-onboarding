package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int wordLen = word.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < wordLen; ++i){
            char curChar = word.charAt(i);
            if(Character.isLetter(curChar)) {
                char leftStandard = setStandard(curChar, "left");
                char rightStandard = setStandard(curChar, "right");
                boolean inLeft = isInLeft(curChar, leftStandard);
                curChar = convertCharacter(curChar, leftStandard, rightStandard, inLeft);
            }
            sb.append(curChar);
        }
        answer = sb.toString();
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

    public static char convertCharacter(char c, char leftStandard, char rightStandard, boolean inLeft) {
        if(inLeft) {
            int distance = leftStandard - c;
            c = (char)(rightStandard + distance);
        } else if(!inLeft) {
            int distance = c - rightStandard;
            c = (char)(leftStandard - distance);
        }
        return c;
    }
}
