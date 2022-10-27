package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = transString(word);
        return answer;
    }

    public static String transString(String word){
        StringBuilder sb = new StringBuilder(word);
        char changeWord;
        for(int i = 0; i < word.length(); i++){
            if('a' <= word.charAt(i) && word.charAt(i) <= 'z'){
                int x = 'z' - word.charAt(i);
                changeWord = (char)('a' + x);
                sb.setCharAt(i, changeWord);
            }
            if('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                int x = 'Z' - word.charAt(i);
                changeWord = (char)('A' + x);
                sb.setCharAt(i, changeWord);
            }
        }
        return sb.toString();
    }
}
