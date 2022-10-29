package onboarding;

public class Problem4 {
    private static char getchar(char c){
        if('a' <= c && c <= 'z'){
            return (char)('a' + 'z' - c);
        }
        if('A' <= c && c <= 'Z'){
            return (char)('A' + 'Z' - c);
        }
        return c;
    }
    public static String solution(String word) {
        //System.out.println(word[0]);
        StringBuffer temp = new StringBuffer("");
        for (int i = 0; i < word.length(); i++){
            temp.append(getchar(word.charAt(i)));
        }
        return temp.toString();
    }
}
