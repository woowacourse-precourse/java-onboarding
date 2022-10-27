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
                if(Character.isLowerCase(curChar)) {

                }
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
}
