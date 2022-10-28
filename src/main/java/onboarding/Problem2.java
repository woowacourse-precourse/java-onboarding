package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        if(CheckCryptogram(cryptogram)){

        }
        throw new IllegalArgumentException();
    }

    private static boolean CheckCryptogram(String str){
        if(isLower(str) && isInRange(str) )return true;
        return false;
    }

    private static boolean isLower(String str){
        char[] charArray = str.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            if( !Character.isUpperCase(charArray[i]))
                return false;
        }
        return true;
    }

    private static boolean isInRange(String str){
        if(str.length() > 0 && str.length() < 1001) return true;
        return false;
    }
}
