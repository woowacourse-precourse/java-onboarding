package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = transString(word);
        return answer;
    }
    public static char getReverseWord(char ch, boolean isUpper){
        if(isUpper){
            int getASCII = 'Z' - ch;
            return (char)('A' + getASCII);
        } else {
            int getASCII = 'z' - ch;
            return (char)('a' + getASCII);
        }
    }
    public static String transString(String word){
        StringBuilder sb = new StringBuilder(word);
        char getWord;
        for(int i = 0; i < word.length(); i++){
            if('a' <= word.charAt(i) && word.charAt(i) <= 'z'){
                getWord = getReverseWord(word.charAt(i), false);
                sb.setCharAt(i, getWord);
            }
            if('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                getWord = getReverseWord(word.charAt(i), true);
                sb.setCharAt(i, getWord);
            }
        }
        return sb.toString();
    }
}
