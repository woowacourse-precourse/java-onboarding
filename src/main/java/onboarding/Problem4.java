package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return messageChange(word);
    }
    public static String messageChange(String word){
        String answer = "";
        for(int i=0;i<word.length();i++){
            answer=answer+asciichange((int)word.charAt(i));
        }
        return answer;
    }
    public static char asciichange(int ch){
        if(ch >= 97 && ch <= 122) return (char)(122+(97-ch));
        else if(ch >= 65 && ch<=90 ) return (char)(90+(65-ch));
        else return (char)ch;
    }

}
