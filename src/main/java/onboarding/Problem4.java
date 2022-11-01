package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            char word_char = word.charAt(i);
            if(checkChar(word_char)) {
                answer += changeWord(word_char);
            }
            else{answer += word_char;}
        }
        return answer;
    }
    static char changeWord(char ch){
        char reverse_ch = 'A';
        if(Character.isUpperCase(ch)){
            reverse_ch = (char) ('Z' - ch + 'A');
        }else{
            reverse_ch = (char) ('z' - ch + 'a');
        }
        return reverse_ch;
    }
    static boolean checkChar(char ch){
        if (ch >= 'a' && ch <= 'z'){return true;}
        if (ch >= 'A' && ch <= 'Z'){return true;}
        return false;
    }
}