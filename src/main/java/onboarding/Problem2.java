package onboarding;

public class Problem2 {

    private static int flag=0;

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static boolean isDuplicate(char target, char nextTarget){
        return target==nextTarget;
    }

    private static boolean isDuplicateLastChar(){
        if(flag==1){
            return true;
        }else{
            return false;
        }
    }
}
