package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int w;
        int len = word.length();
        for(int i=0;i<len;i++){
            w = (int) word.charAt(i);
            if((65<=w)&(w<=90)){
                answer += (char)(155-w);
            }
            else if((97<=w)&(w<=122)){
                answer += (char)(219 - w);
            }
            else{
                answer += (char)w;
            }
        }
        return answer;
    }
}
