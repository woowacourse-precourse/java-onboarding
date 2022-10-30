package onboarding;

public class Problem2 {
    public Problem2(){
    }

    public static String solution(String cryptogram) {
        if(strLenException(cryptogram)){
            return "";
        }
        String answer = "answer";
        return answer;
    }

    public static boolean strLenException(String string){
        return string.length() < 1 || string.length() > 1000;
    }
}
