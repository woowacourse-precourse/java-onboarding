package onboarding;

public class Problem2 {

    public static StringBuilder sb = new StringBuilder();

    public static String solution(String cryptogram) {

        String answer = "answer";
        sb.append(cryptogram);
        answer=sameLetterCheck();

        return answer;
    }
    static String sameLetterCheck(){
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i-1)==sb.charAt(i)){

            }
        }
        return sb.toString();
    }
}
