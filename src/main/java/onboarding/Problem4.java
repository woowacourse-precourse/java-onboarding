package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if (!checkInput(word))
            return null;
        String ret = "";
        for (int i = 0; i < word.length(); i++){
            if (!is_Alpha(word.charAt(i))){
                ret += word.charAt(i);
                continue;
            }
            ret += translateChar(word.charAt(i));
        }
        return ret;
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
