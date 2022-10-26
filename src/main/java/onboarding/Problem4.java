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
            return upperOrLower(c);
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
    public static char upperOrLower(char c){
        char tmp;
        if(97<=c && c<=122){
            tmp = 219;
        }
        else{
            tmp =155;
        }
        return changeCharWithAscii(tmp,c);
    }
    public static char changeCharWithAscii(int num,char c){
        return c;
    }


}
