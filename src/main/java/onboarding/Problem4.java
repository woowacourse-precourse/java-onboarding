package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = reString(word);
        return answer;
    }
    public static String reString(String s){
        String str = "";
        for(int i=0;i<s.length();i++) {
            str += reChar(s.charAt(i));
        }
        return str;
    }
    public static char reChar(char c){
        if( c==' '){
            return c;
        }
        else{
            return changeChar(c);
        }
    }
    public static char changeChar(char c){

        return c;
    }

}
