package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] ch = word.toCharArray();
        for(int i = 0; i< word.length(); i++){
            if(!isAlphabet(ch[i]))
                continue;
            ch[i] = replace(ch[i]);
        }
        return String.valueOf(ch);
    }

    private static Character replace(char ch){
        if(isUpperCase(ch)){
            ch = (char) ('A' + 'Z' - ch);
        } else if (isLowerCase(ch)) {
            ch = (char) ('a' + 'z' - ch);
        }
        return ch;
    }

    private static boolean isAlphabet(char ch){
        if (isUpperCase(ch) || isLowerCase(ch)){
            return true;
        }
        return false;
    }

    private static boolean isUpperCase(char ch){
        if (ch >='A' && ch <= 'Z'){
            return true;
        }
        return false;
    }

    private static boolean isLowerCase(char ch){
        if (ch >= 'a' && ch <= 'z'){
            return true;
        }
        return false;
    }
}
