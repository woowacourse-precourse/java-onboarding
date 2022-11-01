package onboarding;

public class Problem4 {
    private static char reverse(char alpha){
        if ('A'<=alpha && alpha<='Z') {
            int index = (int)alpha - (int)'A';
            alpha = (char) ((int)'A' + 25 - index);
        }
        if ('a'<=alpha && alpha<='z') {
            int index = (int)alpha - (int)'a';
            alpha = (char) ((int)'a' + 25 - index);
        }

        return alpha;
    }
    private static String reverseWord(String word){
        String ret = "";
        for (int index = 0;index<word.length();index++){
            char alpha = word.charAt(index);
            if(('a'<=alpha&&alpha<='z')||'A'<=alpha&&alpha<='Z'){
                ret+=reverse(alpha);
            }
            if(alpha<'A'|| (alpha>'Z'&&alpha<'a') || alpha>'z'){
                ret+=alpha;
            }
        }
        return ret;
    }
    public static String solution(String word) {
        String answer = "";
        answer = reverseWord(word);
        return answer;
    }
}
