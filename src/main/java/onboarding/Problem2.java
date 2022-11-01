package onboarding;

public class Problem2 {

    public static int checkDuplicate(StringBuilder str){
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) return i;
        }return -1;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
