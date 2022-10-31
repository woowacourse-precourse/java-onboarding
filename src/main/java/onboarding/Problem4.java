package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        if(checkException(word)){
            throw new IllegalArgumentException();
        }
        return answer;
    }
    public static boolean checkException(String word){
        if(word == null || checkLength(word.length()) || !checkAlpa(word)){
            return true;
        }
        return false;
    }
    public static boolean checkLength(int length){
        return length < 1 || length >1000;
    }
    public static  boolean checkAlpa(String word){
        return word.matches("^[a-zA-Z\\s]*$");
    }
}
