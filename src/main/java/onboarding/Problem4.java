package onboarding;

public class Problem4 {
    static int flag = 0;
    public static String solution(String word) {
        String answer = "";
        answer = splitString(word);
        return answer;
    }
    static String splitString(String word){
        String result = "";
        String[] wordarr = word.split("");
        for(int i=0; i<wordarr.length; i++){
            if(checkAlpha(wordarr[i])) {
                result += changeAlpha(wordarr[i]);
                continue;
            }
            result += wordarr[i];
        }
        return result;
    }
    static boolean checkAlpha(String oneword){
        if((int)oneword.charAt(0) >= 65 && (int)oneword.charAt(0) <=90) {
            flag = 1;
            return true;
        }
        if((int)oneword.charAt(0) >= 97 && (int)oneword.charAt(0) <=122) {
            flag = 2;
            return true;
        }
        flag = 0;
        return false;
    }
    static char changeAlpha(String oneword){
        char reverseword = 0;
        if(flag == 1) reverseword = (char)(155-(int)oneword.charAt(0));
        if(flag == 2) reverseword = (char)(219-(int)oneword.charAt(0));
        return reverseword;
    }
}
