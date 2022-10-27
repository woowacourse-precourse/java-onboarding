package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean checkAlphabet(int asciiNum) {
        if (asciiNum < 65 || (asciiNum > 90  && asciiNum < 97) || asciiNum > 122) {
            return false;
        }
        return true;
    }

    public static char changeLetter(int asciiNum) {
        int TOTAL = 0;
        if (asciiNum <= 90) {
            TOTAL = (int)'A' + (int)'Z';
        }
        if(asciiNum >= 97){
            TOTAL = (int)'a' + (int)'z';
        }
        return (char)(TOTAL - asciiNum);
    }
}
