package onboarding;


public class Problem4 {
    public static String solution(String word) {
        String str = "";
        for (char c : word.toCharArray()) {
            str += getOppositeWord(c);
        }
        return str;
    }
    static char getOppositeWord(char c) {

        int asciiCode = (int)c;

        if(asciiCode >= 65 && asciiCode <= 90) {
            return (char)(155 - asciiCode);
        }

        else if (asciiCode >= 97 && asciiCode <= 122) {
            return (char)(219 - asciiCode);
        }

        return c;
    }
}
