package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        if(checkException(cryptogram)){
            throw new IllegalArgumentException();
        }
        return getDecoding(cryptogram);
    }
    public static String getDecoding(String cryptogram){

        String regex="{2,}";
        for(char c : cryptogram.toCharArray()){
            cryptogram= cryptogram.replaceAll(c+regex,"");
        }
        return cryptogram;
    }
    public static boolean checkException(String cryptogram){
        if(checkLength(cryptogram.length())){
            return true;
        }

        return false;
    }
    public static boolean checkLength(int length){
        return length < 1 || length > 1000;
    }

}
