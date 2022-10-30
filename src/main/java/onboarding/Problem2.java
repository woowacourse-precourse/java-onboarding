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

    private static String removeDuplicate(String cryptogram){
        String result="";
        for(int i=0;i<cryptogram.length()-1;i++){
            if(isDuplicate(cryptogram.charAt(i),cryptogram.charAt(i+1))){
                flag=1;
            }else{
                if(isDuplicateLastChar()){
                    flag=0;
                }else{
                    result+=cryptogram.charAt(i);
                    flag=0;
                }
            }
        }
        return result+'*';
    }
}
