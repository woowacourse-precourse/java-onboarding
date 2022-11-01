package onboarding;

public class Problem4 {
    public static String solution(String word) {

    }

    private static boolean checkInput(String word){
        if (word.length() < 1 || word.length() > 4000)
            return false;
        return true;
    }
    private static boolean is_Alpha(char c){
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
            return true;
        return false;
    }
    private static char translateChar(char c){
        boolean flag = Character.isLowerCase(c);
        if (flag)
            c -= 32;
        if (c < 'N')
            c = (char)('Z' - (c - 'A'));
        else
            c = (char)('A' + ('Z' - c));
        if (flag)
            c += 32;
        return c;
    }
}
