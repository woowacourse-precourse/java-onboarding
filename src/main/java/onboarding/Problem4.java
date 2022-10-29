package onboarding;

public class Problem4 {
    public static char convertAlphabet(char alphabet) {
        int convertAscii = 0;
        int ascii = 0;
        if(Character.isUpperCase(alphabet)){
            ascii = Character.getNumericValue(alphabet);
            convertAscii = Math.abs(155 - ascii);
        } else if (Character.isLowerCase(alphabet)) {
            ascii = Character.getNumericValue(alphabet);
            convertAscii = Math.abs(219 - ascii);
        }
        char convert = (char)(convertAscii);
        return convert;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
