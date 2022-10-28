package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer="";
        return answer;
    }
    public static void add(StringBuilder answer,String cryptogram,int index){
        answer.append(cryptogram.charAt(index));
        if(index==cryptogram.length()-2){
            answer.append(cryptogram.charAt(index+1));
        }
    }
    public static boolean duplicate(String cryptogram,int index){
        return cryptogram.charAt(index) == cryptogram.charAt(index + 1);
    }
}
