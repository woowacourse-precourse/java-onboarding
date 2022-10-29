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
        return false;
    }
    static char changeAlpha(String oneword){
        char reverseword = 0;
        return reverseword;
    }
}
