package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int l=word.length();
        char c;
        int tmp;
        for(int i=0; i<l; i++){
            c=word.charAt(i);
            if((int)c<=90&&(int)c>=65) c=(char)(155-(int)c);
            else if((int)c<=122&&(int)c>=97) c=(char)(219-(int)c);
            answer+=c;
        }
        return answer;
    }
}
