package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        for(int i=0;i<word.length();i++){
            int chr=(int)word.charAt(i);
            if(chr>=65 && chr<=90){
                chr-=65;
                chr=90-chr;
            }
            else if(chr>=97 && chr<=122){
                chr-=97;
                chr=122-chr;
            }
            answer+=(char)chr;
        }
        return answer;
    }
}
