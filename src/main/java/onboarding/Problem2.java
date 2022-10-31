package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String repeatWords(String s){
        String repeat="";
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1)==s.charAt(i)){
                repeat = String.valueOf(s.charAt(i-1))+String.valueOf(s.charAt(i));
            }
        }
        return repeat;
    }
}
