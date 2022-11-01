package onboarding;

public class Problem2 {

    private static final int minLength = 1;
    private static final int maxLength = 1000;
    private static int flag=0;

    public static String solution(String cryptogram) {
        isValidate(cryptogram);
        cryptogram=cryptogram+'*';
        while(true){
            if (isDuplicateString(cryptogram)){
                cryptogram=removeDuplicate(cryptogram);
            }else{
                break;
            }
        }
        return cryptogram.substring(0, cryptogram.length()-1);
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

    private static boolean isDuplicateString(String cryptogram){
        for(int i=0;i<cryptogram.length()-1;i++){
            if(isDuplicate(cryptogram.charAt(i),cryptogram.charAt(i+1))){
                return true;
            }
        }
        return false;
    }

    private static void isValidate(String cryptogram) {
        if (!isInRange(cryptogram)) {
            throw new IllegalArgumentException("길이가 1이상 1000이하 이어야 합니다.");
        }
        if (!isLowerCase(cryptogram)) {
            throw new IllegalArgumentException("알파벳은 소문자로여야 합니다.");
        }
    }

    private static boolean isInRange(String cryptogram) {
        return minLength <= cryptogram.length() && cryptogram.length() <= maxLength;
    }

    private static boolean isLowerCase(String cryptogram) {
        for (char alphabet : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(alphabet)) {
                return false;
            }
        }
        return true;
    }
}
