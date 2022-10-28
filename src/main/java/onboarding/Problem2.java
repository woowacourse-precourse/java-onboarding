package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = "";
        for(int i =0; i<cryptogram.length(); i++){
            if(cryptogram.charAt(i-1)!=cryptogram.charAt(i) && cryptogram.charAt(i)!=cryptogram.charAt(i+1) ){
                result += cryptogram.charAt(i);
            }
        }   
        
        String answer = "answer";
        return answer;
    }
}
