package onboarding;

public class Problem4 {
    static final int standard = 26;
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean isUpper(char alphabet){
        if(alphabet >= 'A' && alphabet <= 'Z'){
            return true;
        }
        return false;
    }

    public static boolean isLower(char alphabet){
        if(alphabet >= 'a' && alphabet <= 'z'){
            return true;
        }
        return false;
    }

    public static String change(char alphabet){
        int ascii = getAscii(alphabet);
        String changed = String.valueOf((char)ascii);
        return changed;
    }

    public static int getAscii(char alphabet){
        int ascii = 0;
        if(isUpper(alphabet)){
            ascii = (standard - (alphabet - 'A' + 1)) + 'A';
        }
        if(isLower(alphabet)){
            ascii = (standard - (alphabet - 'a' + 1)) + 'a';
        }
        return ascii;
    }
}
