package onboarding;

public class Problem4 {
    private static char translateChar(char c){
        if('a' <= c && c <= 'z'){
            return (char)('a' + 'z' - c);
        }
        if('A' <= c && c <= 'Z'){
            return (char)('A' + 'Z' - c);
        }
        return c;
    }
    public static String solution(String word) {
        StringBuffer temp = new StringBuffer("");
        for (int i = 0; i < word.length(); i++){
            temp.append(translateChar(word.charAt(i)));
        }
        return temp.toString();
    }
}
