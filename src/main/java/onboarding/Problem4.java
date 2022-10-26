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
        if( checkIfNotAlphabet(c)){
            return changeChar(c);
        }
        else{
            return c;
        }
    }
    public static boolean checkIfNotAlphabet(char c){
        if((97<=c && c<=122) || (65<=c && c<=90)){
            return true;
        }
        return false;
    }
    public static char changeChar(char c){

        return c;
    }


}
