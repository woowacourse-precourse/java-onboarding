package onboarding;

public class Problem2 {
    public Problem2(){
    }

    public static String solution(String cryptogram) {
        if(strLenException(cryptogram)){
            return "";
        }
        if(!isStringLowerCase(cryptogram)){
            return "";
        }
        String answer = "answer";
        return answer;
    }

    public static boolean strLenException(String string){
        return string.length() < 1 || string.length() > 1000;
    }

    public static boolean isStringLowerCase(String string){
        char[] charArray = string.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(!Character.isLowerCase(charArray[i]))
                return false;
        }
        return true;
    }
}
