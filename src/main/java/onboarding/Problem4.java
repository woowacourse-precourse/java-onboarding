package onboarding;

public class Problem4 {
    public static String solution(String word) {
        if(input_exception(word)) return "input error";

    }

    private static boolean input_exception(String input){
        //true is 'exception excution'
        if(input.length()<1||input.length()>1000) return true;

        return false;
    }
}
