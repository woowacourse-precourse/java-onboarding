package onboarding;

public class Problem4 {
    private static final int CONVERSION(int x){
        return 25-x;
    }

    public static String solution(String word) {
        if(input_exception(word)) return "input error";

        return getWord(word);
    }

    private static String getWord(String word){

    }

    private static boolean input_exception(String input){
        //true is 'exception excution'
        if(input.length()<1||input.length()>1000) return true;

        return false;
    }
}
